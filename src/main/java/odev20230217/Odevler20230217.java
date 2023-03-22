package odev20230217;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Odevler20230217 extends BaseClass20230217{

    @Test
    public void Odev1(){
        setDriver();
       // 1.https://demo.openmrs.org/openmrs/login.htm sayfasina gidin
        driver.get("https://demo.openmrs.org/openmrs/login.htm");

       // 2."Location for this session:" altinda bulunan kutu icindeki 6 adet linke aralarda 1 sn bekleme vererek tiklayin
        click(By.xpath("//ul/li[@id='Inpatient Ward']"));
        sleep(1000);
        click(By.xpath("//ul/li[2][contains(text(),'Isolation')]"));
        sleep(1000);
        click(By.xpath("//ul/li[3][@id='Laboratory']"));
        sleep(1000);
        click(By.xpath("//ul/li[4][text()='Outpatient Clinic']"));
        sleep(1000);
        click(By.xpath("//ul/li[@class='selected']"));
        sleep(1000);
        click(By.xpath("//ul/li[@value='5']"));
        sleep(1000);


        closeDriver();
    }
    @Test
    public void Odev1FindElements(){
        String url="https://demo.openmrs.org/openmrs/login.htm";
        By linklerLocator = By.xpath("//ul//li");
        setDriver();
        navigateTo(url);
        List<WebElement> linkler=driver.findElements(linklerLocator);

        for (WebElement webElement : linkler) {
            webElement.click();
            sleep(1000);

        }

        closeDriver();
    }
    @Test
    public void Odev1FindElements1(){
        String url="https://demo.openmrs.org/openmrs/login.htm";
        By linklerLocator = By.xpath("//ul//li");
        setDriver();
        navigateTo(url);
        List<WebElement> linkler=driver.findElements(linklerLocator);

        sleep(1000);



        closeDriver();
    }
    @Test
    public void Odev2(){
        setDriver();
        //1. https://demoblaze.com/  sayfasina gidin
        driver.get("https://demoblaze.com/");

        //2. "Log in" butonuna tiklayin
        click(By.cssSelector(" a[class='nav-link'][id='login2']"));

        //3. Dialog icindeki "Log in" butonunun visible oldugunu assert edin.
        boolean displayed = driver.findElement(By.xpath("//div[@class='modal-footer']//button[@onclick='logIn()']")).isDisplayed();
        Assert.assertTrue(displayed);

        //5. "x" butonu ile dialog'u kapatin
        click(By.xpath("//div[@class='modal fade show']//span"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='modal fade show']//span")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//div[@class='modal fade show']//span")).isDisplayed());

        //6. Dialogun kapandigini "Close" butonunun visibility'sine bakarak assert edin
        By closeButton=By.xpath("//div[@id='exampleModal']//button[text()=Close]");
        Assert.assertFalse(driver.findElement(closeButton).isDisplayed());

        closeDriver();
    }
    @Test
    public void Odev3(){
        setDriver();
       // 1. https://automationexercise.com/ sayfasina gidin
        driver.get("https://automationexercise.com/");

       // 2. Menüde Products'a tiklayin
        click(By.xpath("//a[@href='/products']"));

       // 3. Acilan sayfada Search Product inputbox'ina "Men Tshirt" send edin
        sendKeys(By.xpath("//a[@data-toggle='collapse'][@href='#Men']"),"Men Tshirt");

       // 4. Input box yanindaki button'a tiklayin
        click(By.xpath("//button[@id]/i"));

       // 5. Arama sonucunda listelenen ürünün

       // a. kodunun "Rs. 400"
        By productCode =By.cssSelector(".productinfo.text-center h2");
        By productCode1 =By.cssSelector(".productinfo.text-center p");
       // b. adinin "Men Tshirt"
        Assert.assertEquals(driver.findElement(productCode).getText(),"Rs. 400");
        Assert.assertEquals(driver.findElement(productCode).getText(),"Men Tshirt");

       //  oldugunu assert edin. (AssertEquals)
        closeDriver();
    }
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


}
