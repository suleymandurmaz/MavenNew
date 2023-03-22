package gun10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {

    WebDriver driver;
    WebDriverWait wait;

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void deneme() {
        driver.get("http://opencart.abstracta.us/");

        WebElement element = driver.findElement(By.xpath("//a//span[text()='My Account']"));
        Click(element);
        By loginlick = (By.xpath("//a[text()='Login']"));
        waitForVisibilityOf(loginlick);
        Click(loginlick);
        WebElement element2 = driver.findElement(By.cssSelector("#input-email"));
        element2.sendKeys("deneme@deneme");
        WebElement element3 = driver.findElement(By.cssSelector("#input-password"));
        element3.sendKeys("deneme");
        WebElement element4 = driver.findElement(By.xpath("//input[@type='submit']"));
        Click(element4);

        driver.quit();


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
