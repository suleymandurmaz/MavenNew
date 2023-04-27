package Selenium.TestNg.Question5;

import Selenium.Browsers;
import Selenium.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindByLocators {

     WebDriver driver;
       /*  1.  nhttps://opencart.abstracta.us/
        2.  POM, PageFactory -> @FindBy kullanilacak
        3.  LoginPage olusturun
        4.  url ve login icin kullanilacak locatorlar bu class'da
            @FindBy ile tanimlanacak
        5.  TestLogin class'inda login testi olacak ve
            login olundugu assert edilecek.
*/



     String url="https://opencart.abstracta.us/";

     public FindByLocators() {
          //driver= Driver.getDriver(Browsers.valueOf());
          PageFactory.initElements(driver,this);
          driver.manage().window().maximize();

     }

     @FindBy(xpath = "//span[text()='My Account']")
     public WebElement lMyAccount;

     @FindBy(xpath = "//nav[@id='top']//a[text()='Login']")
     public WebElement login;

     @FindBy(xpath = "//input[@id='input-email']")
     public WebElement email;

     @FindBy(xpath = "//input[@id='input-password']")
     public WebElement password;

     @FindBy(xpath = "//input[@type='submit']")
     public WebElement submitLogin;

     @FindBy(xpath = "//a[text()='Newsletter']")
     public WebElement newsLetter;
     public void goToUrl(){
          driver.get(url);
     }


}
