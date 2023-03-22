package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;
    public static WebDriver getDriver(){
        return getDriver(Browsers.CHROME);
    }
    public static WebDriver getDriver(Browsers browsers){
        if (driver==null){
            switch (browsers){
                case FİREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case SAFARI:
                    WebDriverManager.safaridriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    //options.addArguments("--start-maximized");
                    //options.addArguments("--headless");
                    //options.addArguments("user-data-dir=" + System.getProperty("user.home") + "\\AppData\\Local\\Google\\Chrome\\User Data");
                    driver = new ChromeDriver(options);
            }
        }
        return driver;
    }
    public static void quitDriver(){
        driver.quit();
        driver=null;
    }
}
