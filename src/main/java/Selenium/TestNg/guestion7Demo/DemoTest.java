package Selenium.TestNg.guestion7Demo;

import odev20230217.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DemoTest extends BaseDemo {
    @Test
    public  void  signUpTest(){
        gotoUrl(url);
        click(navbarMenu("Sign up"));
        sendKeys(signUpMenu("sign-username"),myUsername);
        sendKeys(signUpMenu("sign-password"),myPassswordname);
        click(signUpMenuClick("Sign up"));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        alert.accept();



    }
    @Test()
    public  void logIn(){
        gotoUrl(url);
        click(navbarMenu("Log in"));

        sendKeys(logInForm("loginusername"),myUsername);
        sendKeys(logInForm("loginpassword"),myPassswordname);
        click(logInFormClick("Log in"));
        Utils.bekle(1000);
        click(xpathHome);
        click(productMenu("Samsung galaxy s6"));
        Utils.bekle(1000);
        click(lAddtochart);












    }


}
