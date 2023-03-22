package Homework.day13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;




    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void click(By locator) {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

    }

    public void sendKeys(By locator, String text) {
        WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        until.clear();
        until.sendKeys(text);


    }


}
