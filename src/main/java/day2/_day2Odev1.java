package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class _day2Odev1 {
       /*
        A. Firefox browser ile kullanarak
      1. https://opensource-demo.orangehrmlive.com/web/index.php/auth/login  sayfasina gidin
      2. Sayfa Title'in "OrangeHRM" oldugunu assert edin
      3. CurrentURL'de "auth" kelimesinin gectigini assert edin

     */

    public static void main(String[] args) {

        WebDriver driver;

        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        String url= "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


        driver.get(url);
        Assert.assertEquals(driver.getTitle(),"OrangeHRM","Başlık Hatası");
        Assert.assertTrue(url.contains("auth"),"Auth İçermez");
        driver.quit();

    }

}
