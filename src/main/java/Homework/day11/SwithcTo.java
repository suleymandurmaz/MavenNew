package Homework.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwithcTo {
    WebDriver driver;
    WebDriverWait wait;

    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Test
            public void odev(){
        String url = "https://demoqa.com/nestedframes";
        driver.get(url);
        driver.manage().window().maximize();



        By parent=By.cssSelector("#frame1Wrapper");
        By child=By.linkText("Child Iframe");
        By ancestor=By.id("framesWrapper");

        System.out.println("driver.findElement(By.id(\"body\")).getText() = " +
                driver.findElement(By.cssSelector("body")).getText());

        driver.switchTo().frame("frame1");

        System.out.println("driver.findElement(By.id(\"body\")).getText() = " +
                driver.findElement(By.cssSelector("body")).getText());






    }







    /*// ana penceredyiz
        driver.get(url);

    // body ana pencerenin body'si
        System.out.println(driver.findElement(By.cssSelector("body")).getText());

    // frame1'e atladik
        driver.switchTo().frame("frame1");

    // body frame1'in body'si
    // frame1 icinde driver.findElement(By) ile aranan tütm selectorler frame1 icinde aranir
    // be parentFrame'de ne de child iframe icinde aranmaz
        System.out.println(driver.findElement(By.cssSelector("body")).getText());

    // frame1 icinde yalniz 1 adet iframa var. index kullanilabilir, ifame element olarak da tanimlanabilir
    WebElement childFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(childFrame);
    //driver.switchTo().frame(0);

        System.out.println(driver.findElement(By.cssSelector("p")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.cssSelector("#framesWrapper>div")).getText());



        driver.quit();*/

}
