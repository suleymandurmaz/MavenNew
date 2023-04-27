package Selenium.TestNg.Question5.gun8;

import Selenium.Browsers;
import Selenium.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestParalelBase  {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeTest
    public void beforetest() {
        driver = Driver.getDriver(Browsers.EDGE);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }



    @AfterTest
    public void aftertest() {
        driver.quit();


    }
}
