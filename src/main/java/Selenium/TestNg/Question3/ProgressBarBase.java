package Selenium.TestNg.Question3;

import Selenium.Browsers;
import Selenium.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProgressBarBase extends ProgressBarLocators {
    protected WebDriver driver;

    protected WebDriverWait wait;

    @BeforeSuite
    public void beforeSuit() {
        driver = Driver.getDriver(Browsers.EDGE);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuit() {
        Driver.quitDriver();
    }

    public void visible(By locator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void open() {

        driver.get(url);
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        click(element);

    }

    public void click(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void yuzdeStop(){
        click(lButton);
        while (true){
            String text = driver.findElement(lProgressBar).getText();
            int percent=text.length() > 0 ? Integer.parseInt(text.replaceAll("[^0-9]","")) : 0;
            if (percent>=60){
                click(lButton);
                getScreenShot("Test1");
                break;
            }

        }

    }
    public void getScreenShot(String name){
        String fileDest= "screenshots/" + name + "-" + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy_MM_dd"))+".png";

        File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File target=new File(fileDest);

        try {
            FileUtils.copyFile(source,target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
