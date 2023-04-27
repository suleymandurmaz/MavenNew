package Selenium.TestNg.Question5.gun8;

import Selenium.Browsers;
import Selenium.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage1 {
    private WebDriver driver;
    private WebDriverWait wait;


    String url = "https://opencart.abstracta.us";


    @FindBy(xpath = "//div[@id='top-links']//a[contains(., 'My Account')]")
    public WebElement eMyAccountLink;

    @FindBy(xpath = "//div[@id='top-links']//a[contains(., 'Login')]")
    public WebElement eMyAccountLoginLink;

    @FindBy(xpath = "//div[@id='top-links']//a[contains(., 'Logout')]")
    public WebElement eMyAccountLogouLink;

    @FindBy(id = "input-email")
    public WebElement eLoginFormUsername;

    @FindBy(id = "input-password")
    public WebElement eLoginFormPassword;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement eLoginSubmitButton;

    @FindBy(xpath = "//aside//a[text()='My Account']")
    public WebElement eRightMenuMyAccount;


   /* @FindBy(xpath = "//aside//a[text()='Login']")
    public WebElement eRightMenuLogin;

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
    @FindBy(xpath = "//div[@id='top-links']//a[contains(., 'Logou')]")
    public  WebElement lLogout;
*/
    public HomePage1(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public HomePage1() {
        driver=Driver.getDriver(Browsers.EDGE);
        PageFactory.initElements(driver,this);

    }

    public   void  click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }
    public  void  sendkeys(WebElement element,String text){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(element));
        e.clear();
        e.sendKeys("text");


    }
    public  WebElement waitUntiVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public  void  gotoUrl(){
        driver.get(url);
    }
    public  void  login(){
        click(eMyAccountLink);
       waitUntiVisible(eMyAccountLoginLink);

       click(eMyAccountLoginLink);
       sendkeys(eLoginFormUsername,"deneme@deneme.com");
       sendkeys(eLoginFormPassword,"deneme");
       click(eLoginSubmitButton);
       waitUntiVisible(eRightMenuMyAccount);

    }
    public  void logout(){
        click(eMyAccountLogouLink);
    }
}
