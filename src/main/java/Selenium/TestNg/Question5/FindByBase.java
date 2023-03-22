package Selenium.TestNg.Question5;

import Selenium.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindByBase {

    WebDriver driver;
    WebDriverWait wait;



    {
        driver= Driver.getDriver();
        //wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();


    }

}
