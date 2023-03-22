package Selenium.TestNg.Question2;

import Selenium.Driver;
import Selenium.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

public class TestOrnekBase implements Locator {
    WebDriver driver;
    WebDriverWait wait;



    @BeforeSuite
    public void beforeSuit(){
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @AfterSuite
    public void afterSuit(){
        Driver.quitDriver();
    }
    @BeforeTest
    public void beforeTest(){
        driver.get(url);
    }
    public void login(){
        sendKeys(luserName,username);
        sendKeys(lPassword,password);
        click(lloginButton);


    }
    public void adminAssert(){
        click(lMenuAdmin);
        click(lUserRoleSelect);
        click(lOptionAdmin);
        click(lsearchButton);
        List<WebElement> elements = driver.findElements(lUserRoleAdmin);
        for (WebElement element : elements) {
            String text = element.getText();
            Assert.assertEquals(text,"Admin");
        }

    }

    public void sendKeys(By locator, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);

    }
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }
}
