package Homework.day15;

import Homework.day13.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static Homework.day15.Locatoes.*;


public class Examples extends Base {
    String url = "https://testpages.herokuapp.com/styled/iframes-test.html";

    @Test
    public void odev1() {

        driver.get(url);


        driver.switchTo().frame(0);
        By iFrame = By.xpath("//h1[text()='iFrame']");
        By iFrames = By.xpath("//ul//li");


        List<WebElement> ilist = driver.findElements(iFrames);
        System.out.println(ilist.size());
        ilist.stream().toList().forEach(System.out::println);
        driver.switchTo().parentFrame();
        //driver.switchTo().frame(1);


        driver.quit();


    }

    @Test
    public void test01Onblur() {
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        click(buttonOnblur);
        String color = driver.findElement(buttonOnblur).getCssValue("background-color");
        System.out.println(color);

        click(buttonOnClick);
        String colorAfter = driver.findElement(buttonOnblur).getCssValue("background-color");
        System.out.println(colorAfter);
        Assert.assertEquals(colorAfter, Color.fromString("#939393").asRgba());
        driver.quit();
    }

    @Test
    public void test01HoverAllButtons() {
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        List<WebElement> buttons = driver.findElements(By.xpath("//button"));

        for (WebElement button : buttons) {
            hover(button);
        }

        driver.quit();

    }

    @Test
    public void keyDown() {
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        WebElement onKeydown = driver.findElement(textOnKeyDown);
        keyDown(onKeydown, Keys.CONTROL);

        driver.quit();


    }

    public void click(By locator) {
        WebElement element = driver.findElement(locator);
        click(element);
    }

    public void click(WebElement element) {
        //new Actions(driver).moveToElement(element).click().build().perform();
        new Actions(driver).click(element).build().perform();
    }

    public void hover(By locator) {
        WebElement element = driver.findElement(locator);
        hover(element);
    }

    public void hover(WebElement element) {
        new Actions(driver).moveToElement(element).build().perform();
    }


    public void contextClick(By locator) {
        WebElement element = driver.findElement(locator);
        new Actions(driver).moveToElement(element).contextClick().build().perform();
        //new Actions(driver).contextClick(element).build().perform();
    }

    public void doubleClick(By locator) {
        WebElement element = driver.findElement(locator);
        new Actions(driver).moveToElement(element).doubleClick().build().perform();
        //new Actions(driver).doubleClick(element).build().perform();
    }

    public void keyDown(WebElement element, Keys key) {
        new Actions(driver)
                .keyDown(element, key)
                .build()
                .perform();
    }
}