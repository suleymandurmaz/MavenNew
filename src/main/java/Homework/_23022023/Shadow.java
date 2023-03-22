package Homework._23022023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Shadow {
    WebDriver driver;
    WebDriverWait wait;

    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Test
    public void shadow1(){

        driver.get("http://uitestingplayground.com/");
        driver.findElement(By.xpath("//a[text()='Shadow DOM']")).click();

        By shadowRoot=By.tagName("guid-generator");
        By id=By.id("editField");
        WebElement element = driver.findElement(shadowRoot);
        element.getShadowRoot().findElement(id).sendKeys("Selam");


        driver.quit();
    }


    //   .  git ->  http://uitestingplayground.com/
    //  2.  "Shadow DOM" linkine tikla
    //  3.  "Playground" yazisi altindaki inputbox'a "guidersoft" send edin.

    @Test
    public void pano(){
        driver.get("https://demoqa.com/text-box");

        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("Mümin");
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("ali@ktm.com");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Ata mah Ankara");
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Türkiye");
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("name"),"Mümin"));

        driver.quit();


    }
    @Test
    public void opencart(){

        driver.get("http://opencart.abstracta.us/");

        WebElement specials = driver.findElement(By.linkText("Specials"));

        JavascriptExecutor special= ((JavascriptExecutor)driver);
        special.executeScript("window.scrollTo(300, 300);");
        special.executeScript("window.scrollBy(0, 300);");
        special.executeScript("arguments[0].scrollIntoView()", specials);
        specials.click();
        WebElement element = driver.findElement(By.xpath("//img[@title='Canon EOS 5D']"));
        element.isDisplayed();


        driver.quit();



        /*1.  git ->  http://opencart.abstracta.us/
        2.  sayfanin en altindaki "Specials" linkine kadar scroll edin (scrollIntoView)
                3.  linke tiklayin
        4.  "Canon EOS 5D" adli ürünün göründügünü assert edin*/
    }

    @Test
    public void odev2(){
        Dimension dimension = new Dimension(600, 700);

        driver.manage().window().setSize(dimension);

        driver.get("https://www.saucedemo.com/");

        WebElement element = driver.findElement(By.id("user-name"));
        element.clear();
        element.sendKeys("standard_user");
        WebElement element1 = driver.findElement(By.id("password"));
        element1.clear();
        element1.sendKeys("secret_sauce");

        WebElement element2 = driver.findElement(By.cssSelector("#login-button"));
        element2.click();

        By lnames=By.cssSelector(".inventory_item_name");
        List<WebElement> until = wait.until(ExpectedConditions.numberOfElementsToBe(lnames, 6));
        for (WebElement webElement : until) {
            try {
                Thread.sleep(1000);
                System.out.println(webElement.getText());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }

        }
       /* 1.  driver.manage().window().setSize(); ile winsize'i (600, 700) yapin
        2.  git ->  https://www.saucedemo.com/
        3.  login olun
        4.  Explicit wait olarak
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, 6)); kullanin
        5.  Tüm ürünleri bir listeye alin ve bu ürünlere sira ile 1 er sn sleep (Thread.sleep) vererek scroll edin

*/

    }
    @Test
    public void odev3() {

        Dimension dimension = new Dimension(600, 700);
        driver.manage().window().setSize(dimension);
        driver.get("https://www.saucedemo.com/");

        WebElement element = driver.findElement(By.id("user-name"));
        element.sendKeys("standard_user");
        WebElement element1 = driver.findElement(By.id("password"));
        element1.sendKeys("secret_sauce");
        WebElement element2 = driver.findElement(By.id("login-button"));
        element2.click();
        List<WebElement> until = wait.until(ExpectedConditions
                .numberOfElementsToBe(By.xpath("//div[@class='inventory_item']"), 6));
        for (WebElement webElement : until) {

            try {
                Thread.sleep(1000);
                System.out.println(webElement.getText());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        driver.quit();
    }
}
