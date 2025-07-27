package ui;

import org.example.URLs;
import org.example.pageObjects.LoginPage;
import org.example.pageObjects.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginUiTest extends BaseUi {

        private LoginPage loginPage;

        @BeforeEach
        public void setUp() {
            driver.get(URLs.LOGIN_PAGE);
            loginPage = new LoginPage(driver);
        }

        @Test
        @DisplayName("Авторизация с корректными данными")
        public void loginCorrectUserTest() {
            loginPage.setUsername("username")
                    .setPassword("password123") // Пароли лучше не хранить в коде
                    .clickLogin();
            new MainPage(driver).checkWelcomeMessage();
        }
}
