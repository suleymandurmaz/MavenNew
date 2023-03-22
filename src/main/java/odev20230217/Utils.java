package odev20230217;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    WebDriver driver;
    WebDriverWait wait;

    public static void bekle(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static WebDriver getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    public void Click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    public void Click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public void sendKeys(By locator,String text){
        WebElement element=waitForVisibilityOf(locator);
        element.clear();
        element.sendKeys(text);
    }
    public WebElement waitForVisibilityOf(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
