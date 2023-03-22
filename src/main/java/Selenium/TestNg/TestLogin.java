package Selenium.TestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestLogin {
    WebDriver driver;
    WebDriverWait wait;
    String url = "https://demowebshop.tricentis.com/";
    String myUsername = "abc123@aa.com";
    String myPassword = "123456";
    By lLoginformUsername = By.id("Email");
    By lLoginformPassword = By.id("Password");
    By lLoginformSubmitButton = By.xpath("//input[@value='Log in']");
    By lLogout = By.xpath("//a[text()='Log out']");
    By lLogin = By.xpath("//a[text()='Log in']");

    /*;



    WebDriver driver;
    WebDriverWait wait;*/

    By lHeaderLoginLink=By.xpath("//div[@class='header-links']//a[text()='Log in']");

    @Test(priority = 0)
    public void gotoUrl() {

        driver.get(url);
        wait.until(ExpectedConditions.titleContains("Demo Web Shop"));
        // driver.get
        // title assert edilecek

    }

    @Test(priority = 1)
    public void clickLinkLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lHeaderLoginLink)).click();
        // log in linkine tiklanacak
    }

    @Test(priority = 3)
    public void fulfillloginForm() {
        wait.until(ExpectedConditions.presenceOfElementLocated(lLoginformUsername)).sendKeys(myUsername);
        wait.until(ExpectedConditions.presenceOfElementLocated(lLoginformPassword)).sendKeys(myPassword);
    }


        // loginform dolduruacak


    @Test(priority = 4)
    public void loginSubmitClick() {
       wait.until(ExpectedConditions.elementToBeClickable(lLoginformSubmitButton)).click();
        // loginform click butonuna tiklanacak

    }

    @Test(priority = 5)
    public void loginAssert() {
        wait.until(ExpectedConditions.elementToBeClickable(lLogout)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLogin));
        // login olundugu assert edilecek

    }


    @BeforeTest
    public void beforeTest() {
        /* WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();*/
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @AfterTest
    public void afterTest() {
        driver.quit();

    }

}


