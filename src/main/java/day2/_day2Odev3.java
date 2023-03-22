package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _day2Odev3 {
  /*    1. https://the-internet.herokuapp.com/login  sayfasina gidin
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
            3. Temiz kod yazmaya özen gösteriniz.
*/

    @Test
    public void findElement(){
        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        String url="https://the-internet.herokuapp.com/login";
        driver.get(url);

        By username= By.id("username");
        By password = By.id("password");
        By loginButton = By.id("login");
        By h2text=By.tagName("h2");
        By h4 = By.tagName("h4");

        String myPassword="SuperSecretPassword!";
        String myUsername="tomsmith";


       //Assert.assertTrue(driver.findElement(By.ByTagName.name("Login Page")).isDisplayed());
        driver.findElement(username).sendKeys(myUsername);
        driver.findElement(password).sendKeys(myPassword);
        driver.findElement(loginButton).click();
        boolean texth2=driver.findElement(h2text).isDisplayed();
        Assert.assertTrue(texth2,"Bulunamadı");
        boolean h4text=driver.findElement(h4).isDisplayed();
        Assert.assertTrue(h4text,"Bulunamadı");


       driver.quit();





    }
    /*1. https://opencart.abstracta.us/index.php?route=account/register     sayfasina gidin
            2. id'si logo elementin visible oldugunu assert edin.
            3. Eger chrome baglanti güvenlik uyarisi verir ise
   "Your connection is not private" uyarisi
    a) alttaki "Advanced" butonuna tiklayin
    b) en alttaki "Proceed to opencart.abstracta.us (unsafe)" linkine tiklayin ve madde-2'yi yapin*/

    @Test
    public void findElement1(){
        WebDriver driver;

        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();


        String url ="https://opencart.abstracta.us/index.php?route=account/register";
        driver.get(url);

        Assert.assertTrue(driver.findElement(By.id("logo")).isDisplayed());





        driver.quit();


    }

}
