package day13;

import io.github.bonigarcia.wdm.WebDriverManager;
import odev20230217.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertSwitchTo {
    WebDriver driver;
    WebDriverWait wait;
    String url = "https://demoqa.com/alerts";

    By lAlertButton = By.cssSelector("#alertButton");
    By lTimerAlertButton = By.id("timerAlertButton");
    By lConfirmButton = By.id("confirmButton");
    By lPromtButton = By.id("promtButton");

    public AlertSwitchTo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void alertButtonTest() {
        driver.get(url);
        wait.until(ExpectedConditions.titleIs("DEMOQA"));

        driver.findElement(lAlertButton).click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        driver.quit();
    }

    @Test
    public void lTimerAlertButton() {
        driver.get(url);
        wait.until(ExpectedConditions.titleIs("DEMOQA"));

        driver.findElement(lTimerAlertButton).click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        driver.quit();
    }

    @Test
    public void lConfirmButton() {
        driver.get(url);
        wait.until(ExpectedConditions.titleIs("DEMOQA"));

        driver.findElement(lConfirmButton).click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("confirmResult"), "Ok"));
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        driver.quit();
    }

    @Test
    public void lPromtButton() {
        driver.get(url);
        wait.until(ExpectedConditions.titleIs("DEMOQA"));

        driver.findElement(lPromtButton).click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("kkk");
        alert.accept();
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        Utils.bekle(3000);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("promptResult"), "kkk"));


        driver.quit();
    }
    @Test
    public void openCart(){

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


        driver.get("http://opencart.abstracta.us/");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();

        WebElement element = driver.findElement(By.xpath("//input[@id='input-email']"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys("deneme@deneme.com");
        WebElement element1 = driver.findElement(By.xpath("//input[@id='input-password']"));
        element1.sendKeys("deneme");
        WebElement element2 = driver.findElement(By.xpath("//input[@type='submit']"));
        element2.click();
        WebElement address_book = driver.findElement(By.linkText("Address Book"));
        address_book.click();
        WebElement new_address = driver.findElement(By.linkText("New Address"));
        new_address.click();
        WebElement element3 = driver.findElement(By.id("input-firstname"));
        element3.sendKeys("Mümin");
        WebElement element4 = driver.findElement(By.id("input-lastname"));
        element4.sendKeys("Özdamar");
        WebElement element5 = driver.findElement(By.id("input-address-1"));
        element5.sendKeys("Ankara");
        WebElement element6 = driver.findElement(By.id("input-city"));
        element6.sendKeys("Yenimahalle");
        WebElement element7 = driver.findElement(By.id("input-postcode"));
        element7.sendKeys("961");

        WebElement element8 = driver.findElement(By.xpath("//select[@id='input-country'])"));
        element8.isSelected();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        alert.accept();
        alert.sendKeys("Turkey");
        alert.accept();
        wait.until(ExpectedConditions.alertIsPresent());


        /*WebElement element9 = driver.findElement(By.xpath("//select[@id='input-zone']"));
        element9.sendKeys("Ankara");
        WebElement element10 = driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value='1']"));
        element10.click();
        WebElement element11 = driver.findElement(By.xpath("//input[@type='submit']"));
        element11.click();

        driver.switchTo().frame("table");
        By body= By.tagName("body");

        driver.switchTo().frame(4);
        wait.until(ExpectedConditions.textToBe(By.id("input-firstname"),"Mümin"));*/

        //driver.quit();


    }
}
