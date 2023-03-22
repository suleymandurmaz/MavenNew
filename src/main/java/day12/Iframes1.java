package day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.crypto.modes.KCCMBlockCipher;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Iframes1 {

    WebDriver driver;
    WebDriverWait wait;

    public Iframes1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void deneme1() {
        driver.get("https://the-internet.herokuapp.com/frames ");
        driver.findElement(By.partialLinkText("iFrame")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("example")));

        driver.switchTo().frame(0);

        By body = By.cssSelector("#tinymce p");

        WebElement editor = driver.findElement(body);
        editor.click();
        editor.sendKeys(Keys.CONTROL + "A");


        driver.quit();


    }

    @Test
    public void deneme2() {
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.partialLinkText("iFrame")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("example")));


        driver.findElement(By.xpath("//span[text()='File']")).click();


        driver.findElement(By.xpath("//div[text()='New document']")).click();

        driver.switchTo().frame(0);

        By body = By.id("tinymce");
        driver.navigate().refresh();
        WebElement editor = driver.findElement(body);

        editor.click();
        editor.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
        editor.click();
        editor.sendKeys("Mümin");
        editor.sendKeys(Keys.ENTER);
        editor.sendKeys("ÖZDAMAR");
        editor.sendKeys(Keys.PAGE_UP);
        editor.sendKeys(Keys.HOME);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();


    }
    @Test
    public void deneme4(){
        driver.get("https://demoqa.com/browser-windows");
        System.out.println(driver.getWindowHandle());
        driver.quit();
    }
    @Test
    public void deneme5(){
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.cssSelector("#tabButton")).click();
        System.out.println(driver.getWindowHandles());
        driver.quit();
    }
}


