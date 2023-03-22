package Homework.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Odev2 {
   /* 1. https://opencart.abstracta.us/index.php?route=account/register     sayfasina gidin
            2. id'si logo elementin visible oldugunu assert edin.
            3. Eger chrome baglanti güvenlik uyarisi verir ise
   "Your connection is not private" uyarisi
    a) alttaki "Advanced" butonuna tiklayin
    b) en alttaki "Proceed to opencart.abstracta.us (unsafe)" linkine tiklayin ve madde-2'yi yapin*/

    @Test
    public void hw2(){
        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        String url="https://opencart.abstracta.us/index.php?route=account/register";

        driver.get(url);

        Assert.assertTrue(driver.findElement(By.id("logo")).isDisplayed());

        driver.quit();


    }

}
