package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class _day2Odev2 {
     /*
           B. Chrome browser ile kullanarak
      1. https://demos.bellatrix.solutions/ sayfasina gidin
      2. Sayfa title'inin length'ini, currentURL'i ve pageSource()'u [sayfa kaynak kodlari] consol'a yazdirin.
      3. Title'in uzunlugunun 10'dan büyük oldugunu assert edin.
      4. Current url'in "google" icermedigini assert edin
     */
     public static void main(String[] args) {

         WebDriver driver;

         WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();
         String url="https://demos.bellatrix.solutions/";


         driver.get(url);
         System.out.println("driver.getTitle().length() = " + driver.getTitle().length());
         System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
         System.out.println("driver.getPageSource() = " + driver.getPageSource());

         Assert.assertTrue(driver.getTitle().length()>10,"Başlık Lenght 10'dan küçüktür.");
         Assert.assertFalse(driver.getCurrentUrl().contains("google"),"URl Google İçermektedir.");

         driver.quit();




     }

}
