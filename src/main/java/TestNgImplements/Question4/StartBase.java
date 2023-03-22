package TestNgImplements.Question4;

import Selenium.Driver;
import odev20230217.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class StartBase implements Locators{

    /*  1.  https://opensource-demo.orangehrmlive.com/
        2.  Logi olunuz
        3.  Admin linkine tiklayin
        4.  Add butonu ile kullanici eklenecek
        5.  Ismi cecil olani employee olarak secin
        6.  Diger bilgileri doldurun
        7.  kaydedin ve user kaydi yapildigindan emin olun.
        8.  Kaydedilen kullaniciyi bulun ve edit edin
        9.  Kullanici adi sonuna 1 ekleyin ve kaydedin.
        10. yeni kullaniciyi aratin ve silin
        11. kullanicinin silindiginden emin olun.*/
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void beforeSuit(){
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    /*@AfterSuite
    public void afterSuite(){
        Driver.quitDriver();
    }*/
    public void click(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        click(element);

    }
    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }
    public void sendKeys(By locator, String text){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.clear();
        sendKeys(element,text);
    }
    public void sendKeys(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);

    }
    public void open(){

        driver.get(url);
    }
    public void login(){
        sendKeys(lUsername,"Admin");
        sendKeys(lPassword,"admin123");
        click(lSubmit);

    }
    public void adnin(){
        Utils.bekle(2000);
        click(lMainMenuAdmin);
        click(lAddButton);
        click(getXpathOfDropDown("User Role"));
        Utils.bekle(2000);
        click(lmenuUserRoleAdmin);
        click(getXpathOfDropDown("Status"));
        click(lmenuStateEnabled);
        sendKeys(lEmployeeName,"p");
        Utils.bekle(500);
        click(lEmployeeName1);
        sendKeys(lUsernameButton,"Safir9876");
        sendKeys(lPasswordButton,"Zz97654321.");
        sendKeys(lConfirmPasswordButton,"Zz97654321.");
        Utils.bekle(2000);
        click(lSaveButton);
        sendKeys(systemUsersUsername,"Safir9876");



    }
    public By getXpathOfDropDown(String title){
        return  By.xpath("//label[contains(.,'"+title+
                "')]/ancestor::div[starts-with(@class,'oxd-grid-item')]//div[@class='oxd-select-text-input']");


    }
    public void visible(By locator,String text1){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String text = element.getText();
        Assert.assertEquals(text,text1);

    }

}
