package Homework.day16;

import Homework.day13.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.backgroundservice.BackgroundService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Forms extends Base {
    String url="https://demoqa.com/automation-practice-form";

    @Test
    public void denemeYeni() {
        driver.get(url);
        By firstName = By.id("firstName");
        WebElement eFirstname = driver.findElement(firstName);

        By lastName = By.id("lastName");
        WebElement elastName = driver.findElement(lastName);

        By userEmail = By.id("userEmail");
        WebElement eUserEmail = driver.findElement(userEmail);

        By male = By.xpath("//input[@id='gender-radio-1']");
        WebElement eMale = driver.findElement(male);

        By mobile = By.xpath("//input[@placeholder='Mobile Number']");
        WebElement emobile = driver.findElement(mobile);

        By dateOfBirthInput = By.cssSelector("#dateOfBirthInput");
        WebElement eDate = driver.findElement(dateOfBirthInput);

        By lMonthOfDate = By.xpath("//select[@class='react-datepickermonth-select']");
        //WebElement eMonthSelect= driver.findElement(lMonthOfDate);



        /*By data_placement = By.xpath("bottom-start");
        WebElement ePlace = element(data_placement);*/

        By ay = By.xpath(("//select[@class='react-datepicker__month-select']/option)[9]"));
        WebElement eAy = driver.findElement(ay);

        By practice = By.xpath("//div[text()='Practice Form']");
        WebElement ePractice = driver.findElement(practice);







/*
        By subjectsContainer = By.id("subjectsContainer");
        By sports = By.id("hobbies-checkbox-1");
        By uploadPicture = By.id("uploadPicture");
        By currentAddress = By.id("currentAddress");
        By state = By.id("state");
        By haryana = By.xpath("//div[text()='Haryana']");
        By city = By.id("city");*/


        new Actions(driver)
                //.scrollToElement(ePractice)
                .sendKeys(eFirstname, "Mümin")
                .sendKeys(elastName, "ÖZDAMAR")
                .sendKeys(eUserEmail, "deneme@deneme.com")
                .click(eMale)
                /*sendKeys(emobile, "21365487")
                .click(eDate)
                .click(eMonthSelect)
*/

                .build()
                .perform();


        //click(dateOfBirthInput);

        /*driver.findElement(dateOfBirthInput).clear();
        click(data_placement);

        click(ay);
        click(yıl);
        click(gun);
        //sendkeys(dateOfBirthInput,"21.10.1976");
        click(subjectsContainer);
        sendkeys(subjectsContainer, "Kayıt");
        click(sports);
        click(uploadPicture);
        click(currentAddress);
        sendkeys(currentAddress, "Ankara");
        click(state);
        click(haryana);
        click(city);*/
        driver.quit();


    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public void clickByAction(WebElement element) {
        new Actions(driver).click().build().perform();
        new Actions(driver).moveToElement(element).click(element).build().perform();

    }

    public void clickJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("argument[0].click(),", element);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js.executeScript("argument[0].click", element);
        {
        }

    }

    public void scroolInToWievq(WebElement element) {
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("argument[0].scrollInToView()", element);
        {
        }
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("argument[0].scrollIntoView;", element);

    }

    public void sendkeys(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);

    }

    public void sendKeysByactions(WebElement element, String text) {
        new Actions(driver).sendKeys(element, text).build().perform();

    }
}
