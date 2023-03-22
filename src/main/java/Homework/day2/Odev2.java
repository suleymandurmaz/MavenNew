package Homework.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Odev2 {
    /*
           B. Chrome browser ile kullanarak
      1. https://demos.bellatrix.solutions/ sayfasina gidin
      2. Sayfa title'inin length'ini, currentURL'i ve pageSource()'u [sayfa kaynak kodlari] consol'a yazdirin.
      3. Title'in uzunlugunun 10'dan büyük oldugunu assert edin.
      4. Current url'in "google" icermedigini assert edin
     */
    @Test
    public void hw2(){
        WebDriver driver;

        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();

        driver.get("https://demos.bellatrix.solutions/");

        System.out.println("driver.getTitle().length() = " + driver.getTitle().length());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        System.out.println("driver.getPageSource() = " + driver.getPageSource());

        boolean b = driver.getTitle().length() > 10;

        Assert.assertTrue(driver.getTitle().length()>10,"Title Küçük");
        Assert.assertFalse(!b,"Title Büyük");
        Assert.assertFalse(driver.getCurrentUrl().contains("google"),"URl Google İçermektedir.");

        driver.quit();
    }
}
