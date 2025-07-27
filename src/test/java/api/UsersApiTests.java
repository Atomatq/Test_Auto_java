package api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.URLs;
import org.example.models.User;
import org.example.utils.DataGenerator;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
*
* Позитивные проверки:
*   - Создание пользователя с валидными данными
*   - Создание пользователя только с обязательными полями
*
* Негативные проверки:
*   - Попытка создания пользователя без обязательных полей
*   - Попытка создания пользователя с некорректными типами полей
*   - Возраст меньше/больше допустимого
*   - Попытка создания уже существующего пользователя
*   - Попытка создания пользователя с уже существующим email
*/
public class UsersApiTests {

    private DataGenerator generator = new DataGenerator();
    private User validUser = generator.generateUserWithValidData();

    @Test
    public void createUserWithValidDataTest() {
        given()
                .baseUri(URLs.BASE_URI)
                .contentType(ContentType.JSON)
                .body(validUser)
                .post(URLs.USERS)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("id", notNullValue())
                .body("name", equalTo(validUser.name()))
                .body("email", equalTo(validUser.email()))
                .body("age", equalTo(validUser.age()));
    }

    @Test
    public void createUserWithoutNameTest() {
        Object withoutName = new Object() {
            String email = validUser.email();
            int age = validUser.age();
        };

        given()
                .baseUri(URLs.BASE_URI)
                .contentType(ContentType.JSON)
                .body(withoutName)
                .post(URLs.USERS)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("error", containsString("name is required"));
    }
}
