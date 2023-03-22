package Homework._23022023;

import dev.failsafe.internal.util.Durations;
import odev20230217.BaseClass20230217;
import odev20230217.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.DimensionUIResource;
import java.time.Duration;

public class Questions {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void question1(){
        driver= Utils.getChromeDriver();

        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://uitestingplayground.com/");

        WebElement click = driver.findElement(By.linkText("Click"));
        wait.until(ExpectedConditions.elementToBeClickable(click)).click();

        WebElement element = driver.findElement(By.cssSelector("#badButton"));

        String colorBeforeClick = element.getCssValue("background-color");
        System.out.println(colorBeforeClick);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        String colorAfterClick = element.getCssValue("background-color");
        System.out.println(colorAfterClick);
        Assert.assertNotEquals(colorBeforeClick,colorAfterClick);


        //1.  git ->  http://uitestingplayground.com/

  //2.  "Click"  linkine tikla
  //3.  "Playground" yazisi altindaki butonun zemin-rengini bir "colorBeforeClick" degiskenine atayin ve consola yazdirin
  //4.  butona tiklayin
  //5.  butonun zemin-rengini "colorAfterClick" degiskenine atayin ve tekrar consola yazdirin
  //6.  colorBeforeClick ve colorAfterClick degerlerinin farkli oldugunu assert edin

       driver.quit();

    }

    @Test
    public void question2(){
        driver=Utils.getChromeDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        WebElement loading_images = driver.findElement(By.linkText("Loading images"));
        wait.until(ExpectedConditions.elementToBeClickable(loading_images)).click();
        //WebElement element = driver.findElement(By.cssSelector("#image-container #compass"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#image-container #compass"))).isDisplayed();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#image-container #compass")));
        //Assert.assertTrue(element.isDisplayed());

        driver.quit();


        //1.  git ->  https://bonigarcia.dev/selenium-webdriver-java/
       // 2.  "Loading images" linkine tikla
       // 3.  cssSelector("#image-container #compass") olan elementin visible oldugunu assert et

    }
    @Test
    public void question3(){
        driver=Utils.getChromeDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(20));

        driver.get("http://uitestingplayground.com/");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("AJAX Data"))).click();
        WebElement element = driver.findElement(By.id("ajaxButton"));
        element.click();

        WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".bg-success")));
        Assert.assertTrue(until.isDisplayed());


        String bgColor=until.getCssValue("background-color");
        String bgColorHex=Color.fromString(bgColor).asHex();

        Assert.assertEquals(bgColorHex,"#28a745");

        driver.quit();



        //1.  git ->  http://uitestingplayground.com/
        //2.  "AJAX Data" linkine tikla
        //3.  "Playground" yazisi altindaki butonuna tiklayin
        //4.  "Data loaded with AJAX get request." textinin göründügünü ve
        //     zemin renginin "#28a745" oldugunu assert edin

    }
    @Test
    public void deneme(){
        driver=Utils.getChromeDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.get("http://uitestingplayground.com");

        WebElement ajax_data = driver.findElement(By.linkText("AJAX Data"));
        wait.until(ExpectedConditions.elementToBeClickable(ajax_data)).click();

        WebElement button = driver.findElement(By.cssSelector(" #ajaxButton"));
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();

        WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".bg-success")));
        Assert.assertTrue(until.isDisplayed());

        String cssValue = until.getCssValue("background-color");
        String cssValue1 = Color.fromString(cssValue).asHex();
        Assert.assertEquals(cssValue1,"#28a745");
        driver.quit();
    }

    @Test
    public void question5(){
        driver=Utils.getChromeDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        WebElement until = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[text()='2']")));
        until.click();

        WebElement until1 = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[text()='+']")));
        until1.click();
        until.click();
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[text()='=']"))).click();


        WebElement until2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".screen")));

        Boolean until3 = wait.until(ExpectedConditions
                .invisibilityOfElementWithText(By.cssSelector(".screen"), "4"));

        Assert.assertTrue(until3);

        driver.quit();


        //1.  Git ->  https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html
       // 2.  Hesap makinesinde 2+2 islemini yapin ve = butonuna tiklayin.
       // 3.  Sonucun 4 oldugunu assert edin. Explicit wait kullaniniz



    }
@Test
public void question4(){
  driver=Utils.getChromeDriver();
  wait=new WebDriverWait(driver,Duration.ofSeconds(10));


    By lheader= By.cssSelector(".container > h3");
    By linput=By.id("editField");
    By lgenerateButton=By.id("buttonGenerate");

    driver.get(" http://uitestingplayground.com/shadowdom");



    wait.until(ExpectedConditions
            .textToBe(lheader,"Shadow DOM"));

    By lsahdowRoot =By.tagName("guid-generator");

    WebElement eshdowRoot=driver.findElement(lsahdowRoot);

    eshdowRoot.getShadowRoot().findElement(linput).sendKeys("shadow");
    eshdowRoot.getShadowRoot().findElement(lgenerateButton).click();
    //   .  git ->  http://uitestingplayground.com/
   //  2.  "Shadow DOM" linkine tikla
  //  3.  "Playground" yazisi altindaki inputbox'a "guidersoft" send edin.



}
}
