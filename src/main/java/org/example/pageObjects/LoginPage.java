package org.example.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginBtn = By.id("loginBtn");

    @Step("Заполнить поле 'username': {username}")
    public LoginPage setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    @Step("Заполнить поле 'password': {password}")
    public LoginPage setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Нажать кнопку 'Login'")
    public LoginPage clickLogin(){
        driver.findElement(loginBtn).click();
        return this;
    }
}
