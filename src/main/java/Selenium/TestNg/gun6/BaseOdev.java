package Selenium.TestNg.gun6;

import Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseOdev {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void beforeTest(){
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
       // driver.manage().window().maximize();

    }
    @AfterTest
    public void afterTest(){
     //  Driver.quitDriver();
    }

}
