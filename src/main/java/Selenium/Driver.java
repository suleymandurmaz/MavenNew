package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver driver;


    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>() ;
    public  static WebDriver getDriver(){
        return getDriver(Browsers.CHROME);
    }
        public static WebDriver getDriver(Browsers browsers) {


            if (drivers.get() == null) {
                switch (browsers) {
                    case FİREFOX:
                        WebDriverManager.firefoxdriver().setup();
                        drivers.set(new FirefoxDriver());
                        break;
                    case SAFARI:
                        WebDriverManager.safaridriver().setup();
                        drivers.set(new SafariDriver());
                        break;
                    case EDGE:
                        WebDriverManager.edgedriver().setup();
                        drivers.set(new EdgeDriver());
                        break;
                    default:
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--remote-allow-origins=*");
                        //options.addArguments("--start-maximized");
                        //options.addArguments("--headless");
                        //options.addArguments("user-data-dir=" + System.getProperty("user.home") + "\\AppData\\Local\\Google\\Chrome\\User Data");
                        drivers.set(new ChromeDriver(options));
                }
            }
            return drivers.get();

        }
        public static void quitDriver() {
            drivers.get().quit();
            drivers.set(null);
        }


}




