package day18;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShot {
    WebDriver driver;
    WebDriverWait wait;

    {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void screnShot() {

        driver.get("http://opencart.abstracta.us/");
        wait.until(ExpectedConditions.titleContains("Your Store"));


        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File target = new File("_screenShot/resim.png");
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        screenShot2();

    }

    public void screenShot2() {
        String name = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy H_m_s"));
        screenShot3(name);

    }


    public void screenShot3(String name) {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File target = new File("_screenShot/" + name + ".png");
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void screenShotElement(WebElement element){
        String name = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy H_m_s"));

        File source = element.getScreenshotAs(OutputType.FILE);
        File target = new File("_screenShot/" + name + ".png");
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
