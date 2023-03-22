package Homework.day14;

import Homework.day13.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.runtime.Runtime;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Set;

public class Actions3 extends Base {


    By inputValEnter = By.id("inputValEnter");
    By product_image=By.xpath("(//source[@class='product-image'])[1]");
    By image=By.xpath("//img[@slidenum='0']");

    String url = "https://www.snapdeal.com/";

    @Test
    public void action2() {

        driver.get(url);
        WebElement eInput = wait.until(ExpectedConditions.presenceOfElementLocated(inputValEnter));



        new Actions(driver)
                .sendKeys(eInput,"SandalMen", Keys.ENTER)
                .build()
                .perform();

        WebElement eProduct = wait.until(ExpectedConditions.presenceOfElementLocated(product_image));
        new Actions(driver)
                .click(eProduct)
                .build()
                .perform();

        String mainWindow = driver.getWindowHandle();
        Set<String> wins= driver.getWindowHandles();

        for (String win : wins) {
            if (!win.equalsIgnoreCase(mainWindow)){
                driver.switchTo().window(win);
            }
        }

        WebElement eImage= wait.until(ExpectedConditions.presenceOfElementLocated(image));

        new Actions(driver)
                .moveToElement(eImage,-20,20)
                .build()
                .perform();

        driver.quit();


    }

    public void presence(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
