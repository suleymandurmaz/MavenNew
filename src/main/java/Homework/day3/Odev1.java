package Homework.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Odev1 {
    WebDriver driver;

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    /*1. https://the-internet.herokuapp.com/login  sayfasina gidin
     2. Sayfadaki h2 elementinin textinin "Login Page" oldugunu asset edin
     3. Formdaki Kullanici ve sifreyi doldurun.
            Kullanici: tomsmith
     Sifre : SuperSecretPassword!
     4. Login butonuna tiklayin
     5. Login oldugunuzdan
     a) h2 elementinin textinin "Secure Area" oldugunu,
     b) h4 elementinin icinde "Welcome to the Secure Area" yazisinin oldugunu
     assert ederek emin olun

        Not: 1. Login Button, H2 ve H4 icin By.tagName kullanabilirsiniz
        2. Locatorlari, sayfayi inspect ederek bulunuz.
        3. Temiz kod yazmaya özen gösteriniz.*/


    @Test
    public void hw1() {

        String url = "https://the-internet.herokuapp.com/login";

        driver.get(url);

        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Login Page");
        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().equals("Login Page"));

        driver.findElement(By.id("username")).sendKeys("tomsmith");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.className("radius")).click();

        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Secure Area");
        Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("Welcome to the Secure Area"));


        driver.quit();

    }

    @Test
    public void hw01() {

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);

        By lh2 = By.tagName("h2");
        By lh4 = By.tagName("h4");
        By className = By.className("radius");
        // By lh2text=By.partialLinkText("Secure Area");

        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        WebElement loginPageLabel = driver.findElement(lh2);
        WebElement locaterh4 = driver.findElement(By.tagName("h4"));

        WebElement lusername = driver.findElement(By.id("username"));
        WebElement lpassword = driver.findElement(By.id("password"));
        String h2text=loginPageLabel.getText();
        String h4text=locaterh4.getText();


        Assert.assertEquals(loginPageLabel.getText(),"Login Page");
        Assert.assertTrue(loginPageLabel.isDisplayed());

        lusername.sendKeys(username);
        lpassword.sendKeys(password);
        driver.findElement(className).click();

        Assert.assertEquals(h2text, "Secure Area");
        Assert.assertTrue(h4text.contains("Welcome to the Secure Area"));

        driver.quit();


    }
}



