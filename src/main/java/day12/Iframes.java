package day12;

import dev.failsafe.internal.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Iframes {
    WebDriver driver;
    WebDriverWait wait;

    public Iframes(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void deneme(){
        driver.get("https://the-internet.herokuapp.com/frames ");
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.switchTo().parentFrame();

        driver.quit();


    }
    @Test
    public void deneme1(){
        driver.get("https://the-internet.herokuapp.com/frames ");
        driver.findElement(By.partialLinkText("iFrame")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("example")));

        driver.switchTo().frame(0);

        By body= By.cssSelector("#tinymce p");

        WebElement editor= driver.findElement(body);
        editor.click();
        editor.sendKeys(Keys.CONTROL+"A");
        driver.quit();



    }

}
