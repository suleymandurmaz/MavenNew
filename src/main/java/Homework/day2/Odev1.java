package Homework.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Odev1 {
    /*
        A. Firefox browser ile kullanarak
      1. https://opensource-demo.orangehrmlive.com/web/index.php/auth/login  sayfasina gidin
      2. Sayfa Title'in "OrangeHRM" oldugunu assert edin
      3. CurrentURL'de "auth" kelimesinin gectigini assert edin

     */
   @Test
    public void hw1(){
       WebDriver driver;
       WebDriverManager.firefoxdriver().setup();
       driver= new FirefoxDriver();

       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       Assert.assertEquals(driver.getTitle(),"OrangeHRM");
       Assert.assertTrue(driver.getCurrentUrl().contains("auth"),"İçermez");

       driver.quit();

   }
}
