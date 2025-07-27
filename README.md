**ЗАДАНИЕ 1**. Анализ и исправление кода 
Описание:
Ниже представлен фрагмент автоматизированного теста. Найдите и исправьте ошибки, укажите слабые места, предложите улучшения (структурные, логические, стилевые, архитектурные).
``
public class LoginTest {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://example.com/login");
    }

    @Test
    public void testLogin() {
        driver.findElement(By.id("username")).sendKeys("user1");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("loginBtn")).click();

        boolean loggedIn = driver.findElement(By.id("welcomeMessage")).isDisplayed();
        Assert.assertTrue(loggedIn);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
``

**ЗАДАНИЕ 2**. Написание тестов 
Описание:
Есть метод, проверяющий корректность номера телефона. Напишите юнит-тесты на этот метод, покрыв граничные случаи и потенциальные баги.

``
public class PhoneValidator {
    public static boolean isValid(String phoneNumber) {
        return phoneNumber.matches("^\\+\\d{1,3}\\d{10}$");
    }
}
``
Дополнительное условие:
Придумайте и добавьте как минимум 2 новых тест-кейса, неочевидных, но потенциально важных.

**ЗАДАНИЕ 3**. Оптимизация и рефакторинг 
Описание:
Ниже представлен метод, который находит все дубликаты в списке.
Отрефакторите метод так, чтобы он стал оптимальнее по времени и читаемости.

``
public List<Integer> findDuplicates(List<Integer> numbers) {
    List<Integer> duplicates = new ArrayList<>();
    for (int i = 0; i < numbers.size(); i++) {
        for (int j = i + 1; j < numbers.size(); j++) {
            if (numbers.get(i).equals(numbers.get(j)) && !duplicates.contains(numbers.get(i))) {
                duplicates.add(numbers.get(i));
            }
        }
    }
    return duplicates;
}
``

**ЗАДАНИЕ 4**. API тестирование
Описание:
Вообразите, что у вас есть REST API по URL: https://api.example.com/users
Метод GET /users?id=123 возвращает информацию о пользователе.
Метод POST /users создает пользователя.
Тело запроса на создание:
``
{
  "name": "John",
  "email": "john@example.com",
  "age": 30
}
``
Задание:
1.Опишите тест-кейсы для проверки POST /users (позитивные и негативные).
2.Реализуйте 1–2 автотеста на Java, используя RestAssured или HttpClient.
3.Какие проверки вы считаете обязательными в API тестах?
