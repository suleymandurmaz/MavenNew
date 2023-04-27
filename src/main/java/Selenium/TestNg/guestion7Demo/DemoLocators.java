package Selenium.TestNg.guestion7Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DemoLocators {
    /*
    https://demoblaze.com/
1.  Static singleton driver kullanilacak, DriverDemo.class
    a.  Hangi browserin kullaniclacagi
    b.  Headless olup olmayacagi -> options.addArguments("--headless")
    c.  browser size, "max, 700x700, ....."
    Driver tanimlamadan önce belirtilecek

2.  signup yapin
3.  sing in yapin
4.  Menüden Phones'a tiklayin
5.  Samsung s6'yi tiklayin
6.  Cart'a ekleyin
7.  Order edip alisverisi tamamlayin.
     */
    // By lSignup= By.xpath("//div[@id='navbarExample']//a[text()='Sign up']");
    String myUsername = "ssuleyman@sul.com";
    String myPassswordname = "ssuleyman";
    String url = "https://demoblaze.com/";

    public By navbarMenu(String text) {
        return By.xpath("//div[@id='navbarExample']//a[text()='" + text + "']");


    }

    public By signUpMenu(String text) {
        return By.xpath("//div[@class='modal-content']//input[@id='" + text + "']");
    }

    public By signUpMenuClick(String text) {
        return By.xpath("//div[@class='modal-content']//button[text()='" + text + "']");

    }

    public By logInForm(String text) {
        return By.xpath("//div[@class='modal-body']//input[@id='" + text + "']");

    }

    public By logInFormClick(String text) {
        return By.xpath("//div[@class='modal-content']//button[text()='" + text + "']");



    }
    public  By  productMenu(String text){
      return  By.xpath("//div[@id='tbodyid']//a[text()='"+text+"']");
    }

        By xpathHome = By.xpath("(//div[@id='navbarExample']//a[@class='nav-link'])[1]");
    By lAddtochart=By.xpath("//div[@class='row']//a[text()='Add to cart']");
    }
