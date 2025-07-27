package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BaseUi {

    protected WebDriver driver;

    @BeforeEach
    public void initWebDriver(){
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
