package odev20230217;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Yeni extends BaseClass20230217{
    @Test
    public void Odev2_1(){
        String url=" https://demoblaze.com/";
        setDriver();
        //1. https://demoblaze.com/  sayfasina gidin
        navigateTo(url);
        sleep(1000);

        //2. "Log in" butonuna tiklayin
        By loginLink = By.xpath("//div[@id='navbarExample']//a[text()='Log in']");
        click(loginLink);

        //3. Dialog icindeki "Log in" butonunun visible oldugunu assert edin.
        By loginButton=By.xpath("//div[@id='logInModal']//button[text()='Log in']");
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed());

        //5. "x" butonu ile dialog'u kapatin
        By xButton=By.xpath("//h5[@id='logInModalLabel']//span");
        click(xButton);


        //6. Dialogun kapandigini "Close" butonunun visibility'sine bakarak assert edin
        By closeButton=By.xpath("//div[@id='logInModal']//button[text()='Close']");
        Assert.assertTrue(driver.findElement(closeButton).isDisplayed());

        closeDriver();
    }
    @Test
    public void Odev3(){
        String url="https://automationexercise.com/";
        setDriver();
        // 1. https://automationexercise.com/ sayfasina gidin
        navigateTo(url);

        // 2. Menüde Products'a tiklayin
        By productsButton=By.xpath("//ul//a[@href='/products']");
        click(productsButton);

        // 3. Acilan sayfada Search Product inputbox'ina "Men Tshirt" send edin
        By searchButton=By.cssSelector("input#search_product");
        sendKeys(searchButton,"Men Tshirt");


        // 4. Input box yanindaki button'a tiklayin
        By buyutec=By.cssSelector("button#submit_search>i");
        click(buyutec);


        By productCode = By.cssSelector(".productinfo.text-center h2");
        By productName = By.cssSelector(".productinfo p");

        Assert.assertEquals(driver.findElement(productCode).getText(), "Rs. 400");
        Assert.assertEquals(driver.findElement(productName).getText(), "Men Tshirt");

        // 5. Arama sonucunda listelenen ürünün

        // a. kodunun "Rs. 400"

        // b. adinin "Men Tshirt"

        //  oldugunu assert edin. (AssertEquals)



        closeDriver();
    }

}
