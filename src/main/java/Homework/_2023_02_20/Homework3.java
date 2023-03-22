package Homework._2023_02_20;

import odev20230217.BaseClass20230217;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework3 extends BaseClass20230217 {

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



        List<WebElement> names = driver.findElements(By.cssSelector(".inventory_item_name"));
        for (WebElement name : names) {
            System.out.println(name.getText());
        }

            List<WebElement> prices = driver.findElements(By.cssSelector(".inventory_item_price"));
            for (WebElement price : prices) {
                System.out.println(price.getText());
            }




        /*System.out.println("elements.stream().toList().size() = " + elements.stream().toList().size());
        elements.stream().toList().forEach(System.out::println);*/


                // 4. Sayfadaki ürünlerin hepsinin
                // a. isimlerini consola yazdirin
                // b. fiyatlarini consola yazdirin*/
                closeDriver();


            }
        }
