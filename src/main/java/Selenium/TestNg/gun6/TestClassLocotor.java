package Selenium.TestNg.gun6;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassLocotor extends BaseOdev{
    By lhome1= By.xpath("(//a[text()='Home'])[1]");
    By lhome2= By.xpath("(//a[text()='Home'])[2]");
    By lproducts=By.xpath("//ul[@class='products columns-4']//a/h2[contains(.,'Falcon 9')]");
    By lproductsname=By.xpath("//h1[contains(.,'Falcon 9')]");
    By lmenu=By.xpath("//button[@id='site-navigation-menu-toggle']");
    String url="https://demos.bellatrix.solutions/";
    @Test
    public  void test1(){
        gottoUrl(url);
        click(lhome1);
        click(lproducts);
       // getText(lproductsname);
        visible(lproductsname,"Falcon 9");


    }
    @Test
    public  void  test2(){
       driver.manage().window().setSize(new Dimension(700,700));

        gottoUrl(url);
        click(lmenu);
        click(lhome2);

       /* click(lproducts);
        visible(lproductsname,"Falcon 9");*/


    }
    public  void gottoUrl(String url){
        driver.get(url);

    }
    public  void click(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        click(element);

    }
    public  void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }
    String text;
    public  void getText(By locator){
        text = wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();


    }
    public  void visible(By locator,String text1){
        getText(locator);
        Assert.assertEquals(text,text1);

    }
    public  void  getMenuVisible(){

    }

}
