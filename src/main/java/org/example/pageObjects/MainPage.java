package org.example.pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By welcomeMessage = By.id("welcomeMessage");

    public void checkWelcomeMessage() {
        Assertions.assertTrue(driver.findElement(welcomeMessage).isDisplayed());
    }
}
