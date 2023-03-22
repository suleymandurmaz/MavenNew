package odev20230217;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass20230217 {
    protected WebDriver driver;
    protected WebElement element;

    public void navigateTo(String url){
        driver.get(url);

    }

    public void setDriver(){
        setDriver("");
    }
    public void setDriver(String browser) {
        switch (browser.toLowerCase()){
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
            case "edge" :
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
            default :
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();

        }


    }

    public void click(By locator) {
        driver.findElement(locator).click();


    }

    public void sendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void sleep(long milis) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
       public void closeDriver(){
        driver.quit();
        }
    }

