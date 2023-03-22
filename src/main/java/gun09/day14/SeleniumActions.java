package gun09.day14;

import Homework.day13.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import odev20230217.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SeleniumActions extends Base {

    String url = ("http://opencart.abstracta.us/");

    @Test
    public void actions() {
        driver.get(url);
        By sli1 = By.cssSelector("ul.nav > li:nth-of-type(1)");
        By sli2 = By.cssSelector("ul.nav > li:nth-of-type(2)");
        WebElement eli1 = driver.findElement(sli1);
        WebElement eli2 = driver.findElement(sli2);

        Actions actions = new Actions(driver);
        Action action = actions
                .moveToElement(eli1)
                .pause(1000)
                .moveToElement(eli2)
                .pause(1000)
                .build();

        action.perform();

        Utils.bekle(3000);
        driver.quit();

        /*new Actions(driver).moveToElement(eli1).pause(1000)
                .moveToElement(eli2).pause(1000).build().perform();*/

    }

    @Test
    public void action1() {
        driver.get(url);

        By slaptops = By.xpath("//li//a[text()='Laptops & Notebooks']");
        By sComponents = By.xpath("//li//a[text()='Components']");
        By sTablets = By.xpath("//li//a[text()='Tablets']");
        By sSoftware = By.xpath("//li//a[text()='Software']");
        By sPhonesPDAs = By.xpath("//li//a[text()='Phones & PDAs']");
        By sCameras = By.xpath("//li//a[text()='Cameras']");
        By MP3_Players = By.xpath("//li//a[text()='MP3 Players']");


        WebElement elaptops = driver.findElement(slaptops);
        WebElement eComponents = driver.findElement(sComponents);
        WebElement eTablets = driver.findElement(sTablets);
        WebElement eSoftware = driver.findElement(sSoftware);
        WebElement ePhonesPDA = driver.findElement(sPhonesPDAs);
        WebElement eCameras = driver.findElement(sCameras);
        WebElement eMP3_Players = driver.findElement(MP3_Players);


        Actions actions = new Actions(driver);

        Action action = actions
                .moveToElement(elaptops)
                .pause(1000)
                .moveToElement(eComponents)
                .pause(1000)
                .moveToElement(eTablets)
                .pause(1000)
                .moveToElement(elaptops)
                .pause(1000)
                .moveToElement(ePhonesPDA)
                .pause(1000)
                .moveToElement(eCameras)
                .pause(1000)
                .moveToElement(eSoftware)
                .pause(1000)
                .moveToElement(eMP3_Players)
                .build();

        action.perform();
        driver.quit();

    }
    @Test
    public void action2(){
        driver.get("https://demoqa.com/auto-complete");

        By container = By.id("autoCompleteMultipleContainer");
        WebElement eContainer=driver.findElement(container);

        Actions actions=new Actions(driver);

        Action action=actions
                .moveToElement(eContainer)
                .click(eContainer)
                .pause(1000)
                .sendKeys("a")
                .pause(1000)
                .sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER)
                .pause(1000)
                .build();
        action.perform();


        Utils.bekle(3000);
        driver.quit();


    }
    @Test
    public void action4(){
       /* 1.  https://www.snapdeal.com/
        2.  cookileri kabul edin
        3.  "watch" aratin
        4.  ilk ürüne tiklayin
        5.  ürün resmi üzerinde sol üst köseden sag alt köseye kadar mousei hareket ettirin*/
        driver.manage().deleteAllCookies();
        driver.get("https://www.snapdeal.com/");

        By search = By.cssSelector("#inputValEnter");
        By search1=By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']");
        By productBigPicture = By.cssSelector("img[slidenum='0']");



        WebElement eSearch= driver.findElement(search);
        WebElement eSearch1= driver.findElement(search1);

        String windowHandle = driver.getWindowHandle();
        Actions actions=new Actions(driver);
        Action action=actions
                .moveToElement(eSearch)
                .click(eSearch)
                .sendKeys("watch")
                .moveToElement(eSearch1)
                .click(eSearch1)
                .build();

        action.perform();


        By watch=By.xpath("(//picture[@class='picture-elem']/ancestor::a)[1]");
        // By watch1=By.xpath("//div[@id='652415109752']");
        WebElement eWatch= driver.findElement(watch);
        System.out.println(eWatch.getSize());

        new Actions(driver)
                .moveToElement(eWatch)
                .click(eWatch)
                .build().perform();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String ilk:windowHandles) {
            if (!ilk.equalsIgnoreCase(windowHandle)) {
                driver.switchTo().window(ilk);
            }

        }
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        WebElement picture= wait.until(ExpectedConditions.visibilityOfElementLocated(productBigPicture));

        new Actions(driver)
                .moveToElement(picture,-20,20)
                .pause(3000)
                .build().perform();




        driver.quit();
    }
}
