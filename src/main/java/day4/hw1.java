package day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class hw1 {
    /*1.  https://automationexercise.com/  git
      2.  Sayfani acildigini assert edin.
    3.  Sign up / Login linkine tikla
    4.  Login sayfasi oldugunu assert edin
    3.  eMail ve sifre girin
    eMail : aaaa@aa.com
    pass  : 123456
            4.  Hata mesajinin ciktigini assert edin
    5.  browser'i kapatin*/

    @Test
    public void odevv1(){
        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.get( "https://automationexercise.com/");

        Assert.assertEquals(driver.getTitle(),"Automation Exercise");
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/products']")).isDisplayed());
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        boolean displayed = driver.findElement(By.xpath("//a[@href='/login']")).isDisplayed();
        Assert.assertTrue(displayed);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(" aaaa@aa.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("aaa");
        driver.findElement(By.cssSelector(".login-form button")).click();
        boolean displayed1 = driver.findElement(By.xpath("//p[@style='color: red;']")).isDisplayed();
        Assert.assertTrue(displayed1);

        driver.quit();






    }

}
