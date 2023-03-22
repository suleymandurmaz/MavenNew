package TestNgImplements.Question5;

import Selenium.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FindByTests {

    WebDriver driver;
    FindByBase findByBase;
    FindByLocators locators;

    @Test
    public void login() {

        locators = new FindByLocators();
        locators.goToUrl();
        locators.lMyAccount.click();
        locators.login.click();
        locators.email.sendKeys("deneme@deneme.com");
        locators.password.sendKeys("deneme");
        locators.submitLogin.click();
        Assert.assertEquals(locators.newsLetter.getText(), "Newsletter");

    }

    @AfterTest
    public void afterTest() {
        Driver.quitDriver();

    }
    @Test
    public void test(){
        driver=Driver.getDriver();
        FindByLocators findByLocators=PageFactory.initElements(driver,FindByLocators.class);

        findByLocators.goToUrl();
        findByLocators.lMyAccount.click();
        findByLocators.login.click();
        findByLocators.email.sendKeys("deneme@deneme.com");
        findByLocators.password.sendKeys("deneme");
        findByLocators.submitLogin.click();
        Assert.assertEquals(findByLocators.newsLetter.getText(),"Newsletter");


    }

    public static class FindByTestsxml {

        WebDriver driver;
        FindByBase findByBase;
        FindByLocators locators;

        @Test
        public void login() {

            locators = new FindByLocators();
            locators.goToUrl();
            locators.lMyAccount.click();
            locators.login.click();
            locators.email.sendKeys("deneme@deneme.com");
            locators.password.sendKeys("deneme");
            locators.submitLogin.click();
            Assert.assertEquals(locators.newsLetter.getText(), "Newsletter");

        }

        @AfterTest
        public void afterTest() {
            Driver.quitDriver();

        }
        @Test
        public void test(){
            driver=Driver.getDriver();
            FindByLocators findByLocators=PageFactory.initElements(driver,FindByLocators.class);

            findByLocators.goToUrl();
            findByLocators.lMyAccount.click();
            findByLocators.login.click();
            findByLocators.email.sendKeys("deneme@deneme.com");
            findByLocators.password.sendKeys("deneme");
            findByLocators.submitLogin.click();
            Assert.assertEquals(findByLocators.newsLetter.getText(),"Newsletter");


        }
    }
}
