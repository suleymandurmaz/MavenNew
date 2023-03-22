package Homework.day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Odev1 {
    WebDriver driver;
    WebDriverWait wait;

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void odev1() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/frames");
        By iframe = By.xpath("//a[text()='iFrame']");
        WebElement eIFrame = driver.findElement(iframe);
        eIFrame.click();


        driver.switchTo().frame(0);

        By textArea = By.tagName("body");
        WebElement eTextArea = driver.findElement(textArea);
        eTextArea.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        eTextArea.sendKeys("Mümin", Keys.ENTER, "ÖZDAMAR");

        driver.quit();


    }

    @Test
    public void odev2() {

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/frames");
        By iframe = By.xpath("//a[text()='iFrame']");
        WebElement eIFrame = driver.findElement(iframe);
        eIFrame.click();
        By file=By.xpath("//span[text()='File']");
        WebElement element= driver.findElement(file);
        element.click();
        By document=By.xpath("//div[text()='New document']");
        WebElement element1= driver.findElement(document);
        element1.click();
        By bold=By.xpath("//button[@title='Bold']");
        WebElement element2= driver.findElement(bold);
        element2.click();
        By italic=By.xpath("//button[@title='Italic']");
        WebElement element3= driver.findElement(italic);
        element3.click();

        driver.switchTo().frame(0);

        By iframe1=By.cssSelector("body");
        WebElement element4= driver.findElement(iframe1);
        element4.sendKeys("Mümin");

        driver.quit();

    }

    @Test
    public void odev3(){
        driver.get("https://the-internet.herokuapp.com/frames");
        WebElement element = driver.findElement(By.xpath("//a[text()='Nested Frames']"));
        element.click();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement element1 = driver.findElement(By.tagName("body"));
        System.out.println(element1.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        WebElement element2 = driver.findElement(By.tagName("body"));
        System.out.println(element2.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        WebElement element3 = driver.findElement(By.tagName("body"));
        System.out.println(element3.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();


        driver.switchTo().frame("frame-bottom");
        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());

        driver.quit();
    }
}
