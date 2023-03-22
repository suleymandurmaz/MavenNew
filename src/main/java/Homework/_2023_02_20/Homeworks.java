package Homework._2023_02_20;

import odev20230217.BaseClass20230217;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Homeworks extends BaseClass20230217 {

    String url="http://opencart.abstracta.us/";

    @Test
    public void Odev1(){
        setDriver();

       // 1. http://opencart.abstracta.us/  adresine gidin
        navigateTo(url);
       // 2. searchbox'a "mac" yazin
        By searchButton=By.xpath("//input[@name='search']");
        sendKeys(searchButton,"mac");

       // 3. arama butonuna tiklayin
        By buyutec=By.cssSelector("div#search i");
        click(buyutec);

       // 4. kac tane ürün listelendigini ve ürün isimlerini
        By link1=By.cssSelector("img[title='MacBook']");
        By link2=By.cssSelector("img[title='iPhone']");
        By link3=By.cssSelector("img[title='Apple Cinema 30']");
        By link4=By.cssSelector("img[title='Canon EOS 5D']");

        List<By> linkler=new ArrayList<>();
        linkler.add(link1);
        linkler.add(link2);
        linkler.add(link3);
        linkler.add(link4);

        System.out.println("linkler.stream().toList().size() = " + linkler.stream().toList().size());
        linkler.stream().toList().forEach(a-> System.out.println(a));

        closeDriver();

       // driver.findElements() kullanarak ekrana yazdirin

    }
    @Test
    public void Odev2(){

        setDriver();
       // 1. http://opencart.abstracta.us/  adresine gidin
        navigateTo(url);
       // 2. searchbox'a "mac" yazin
        By searchButton=By.cssSelector(".form-control");
        sendKeys(searchButton,"mac");

       // 3. arama butonuna tiklayin
        By aramaButton=By.cssSelector(".fa.fa-search");
        click(aramaButton);

       // 4. ismi "iMac" olan bilgisayarin fiyatini consola yazdirin
        By iMacPrice=By.xpath("(//div/p)[3]");

        System.out.println("driver.findElement(iMacPrice).getText() = " + driver.findElement(iMacPrice).getText());

        List<WebElement> apple=new ArrayList<>(driver.findElements(iMacPrice));

        apple.stream().toList().forEach(System.out::println);

        closeDriver();
    }
    @Test
    public void Odev3() {
        String url = "https://www.saucedemo.com/";

        setDriver();

        // 1. https://www.saucedemo.com/  adresine gidin
        navigateTo(url);

        // 2. kullanici adi ve sifre bilgilerini doldurun ve login butonuna tiklayin
        By username = By.xpath("//input[@id='user-name']");
        sendKeys(username, "standard_user");

        By password = By.xpath("//input[@id='password']");
        sendKeys(password, "secret_sauce");

        // 3. login yaptiginizdan emin olun
        By loginButton = By.cssSelector("#login-button");
        click(loginButton);
        sleep(2000);

        By products = By.xpath("//button[text()='Open Menu']");
        click(products);
        Assert.assertTrue(driver.findElement(products).isDisplayed());

        // 4. Sayfadaki ürünlerin hepsinin
        By inventoryLİst=By.xpath("//div[@id='inventory_container'][@class]");
        WebElement element1= driver.findElement(inventoryLİst);
        System.out.println("element1.getText() = " + element1.getText());



        // a. isimlerini consola yazdirin
        List<WebElement> container=driver.findElements(inventoryLİst);
        container.stream().filter(a->a.isDisplayed());
        System.out.println("container.stream().count() = " + container.stream().count());

        List<WebElement> names = driver.findElements(By.cssSelector(".inventory_item_name"));
        for (WebElement name : names) {
            System.out.println(name.getText());
        }

        // b. fiyatlarini consola yazdirin*/
        List<WebElement> prices = driver.findElements(By.cssSelector(".inventory_item_price"));
        for (WebElement price : prices) {
            System.out.println(price.getText());
        }


        closeDriver();


    }

    @Test
    public void Odev4(){
        String url="https://www.saucedemo.com/";
        setDriver();

        navigateTo(url);
        By username= By.xpath("//input[@id='user-name']");
        sendKeys(username,"standard_user");
        By passWord= By.xpath("//div/input[@id='password']");
        sendKeys(passWord,"secret_sauce");
        // driver.findElement(By.xpath()).click();

        By loginButton=By.xpath("//div//input[@value='Login']");
        click(loginButton);

        By products = By.xpath("//button[text()='Open Menu']");
        click(products);
        Assert.assertTrue(driver.findElement(products).isDisplayed());

        closeDriver();


    }
    @Test
    public void Odev5(){
        setDriver();
        String url="https://www.saucedemo.com/";
        navigateTo(url);
        By username= By.xpath("//input[@id='user-name']");
        sendKeys(username,"standard_user");
        By passWord= By.xpath("//div/input[@id='password']");
        sendKeys(passWord,"secret_sauce");
        By loginButton=By.xpath("//input[@value='Login']");
        click(loginButton);
        By sauceLab=By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");
        List<WebElement> elements = driver.findElements(sauceLab);
        for (WebElement tshirt:elements){
            System.out.println(tshirt.getText());
        }

        List<WebElement> elements1 = driver.findElements(By.xpath("(//div[text()='15.99'])[1] "));
        for(WebElement bolt:elements1){
            System.out.println(bolt.getText());
        }
        closeDriver();
    }

}
