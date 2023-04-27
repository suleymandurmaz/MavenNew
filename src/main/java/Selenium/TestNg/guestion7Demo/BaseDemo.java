package Selenium.TestNg.guestion7Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseDemo extends DemoLocators {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public  void  beforeTest(){
        driver=DemoDriver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @AfterTest
    public  void  afterTest(){
        DemoDriver.quitDemoDriver();
    }
    public void  click(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        click(element);
    }
    public  void  click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }
    public  void  sendKeys(By locators,String text){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locators));
        sendKeys(element,text);

    }
    public  void sendKeys(WebElement element,String  text){
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }
    public void gotoUrl(String url){
       driver.get(url);

    }

}
