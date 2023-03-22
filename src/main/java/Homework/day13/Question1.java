package Homework.day13;

import io.github.bonigarcia.wdm.WebDriverManager;
import odev20230217.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Question1 extends Base{


    @Test
    public void odev(){
        //driver.get(url);
        By my_account = (By.linkText("My Account"));
        By login = By.linkText("Login");
        By email = By.id("input-email");
        By password = By.id("input-password");
        By emailLogin = By.xpath("//input[@type='submit']");
        By adressBook = By.xpath("//li/a[text()='Address Book']");
        By new_address = By.linkText("New Address");
        By firstName = By.xpath("//input[@id='input-firstname']");
        By lastName = By.xpath("//input[@id='input-lastname']");
        By company = By.xpath("//input[@id='input-company']");
        By address_1 = By.xpath("//input[@id='input-address-1']");
        By address_2 = By.xpath("//input[@id='input-address-2']");
        By city = By.xpath("//input[@id='input-city']");
        By postcode = By.xpath("//input[@id='input-postcode']");
        By country = By.xpath("//select[@id='input-country']");
        By Türkiye = By.xpath("//select/option[@value='215']");
        By regionArea = By.xpath("//select[@id='input-zone']");
        By regionAreaAnkara = By.xpath("//select[@id='input-zone']//option[text()='Ankara']");
        By radio=By.xpath("(//label[@class='radio-inline']//input[@value])[1]");
        By continue1 = By.xpath("//input[@type='submit']");
        By sehir = By.xpath("(//table//td//br)[2]");
        By delete=By.xpath("(//a[text()='Delete'])[2]");
        By colum = By.id("column-right");




        click(my_account);
        click(login);
        sendKeys(email,"deneme@deneme.com");
        sendKeys(password,"deneme");
        click(emailLogin);
        click(adressBook);
        click(new_address);
        sendKeys(firstName,"Mümin");
        sendKeys(lastName,"ÖZDAMAR");
        sendKeys(company,"GuiderSoft");
        sendKeys(address_1,"Yenimahalle");
        sendKeys(address_2,"Ata");
        sendKeys(city,"Ankara");
        sendKeys(postcode,"06100");
        click(country);
        click(Türkiye);
        click(regionArea);
        click(regionAreaAnkara);
        click(radio);
        click(continue1);
        Utils.bekle(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(colum));
        click(delete);

        driver.quit();

        /* 1.  https://opencart.abstracta.us/   adresine git
        2.  Login olmak icin Menüdeki MyAccount'a tikla
        3.  Login linki visible oluncaya kadar bekle ve Login'e tikla
        4.  Kullanici adi, sifre gir ve login butonuna tikla
        5.  Login oldugunu assert et
        6.  Sol menüdeki Address Book'a tikla
        7.  New Adress butonuna tikla
        8.  Formu doldur
        9.  Continue butonuna tikla
        10. Adresi kaydettiginizi assert edin*/

    }
}
