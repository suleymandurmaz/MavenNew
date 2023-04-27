package Selenium.TestNg.guestion7Demo;

import Selenium.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;

public class DemoDriver {

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();


    public static WebDriver getDriver() {
        return getDriver(DemoBrowsers.CHROME);

    }

    public static WebDriver getDriver(DemoBrowsers browsers) {
        if (drivers.get() == null) {
            switch (browsers) {
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                    break;
                case SAFARI:
                    WebDriverManager.safaridriver().setup();
                    drivers.set(new SafariDriver());
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                  /*options.addArguments("--headless");
                  options.addArguments("--start-maximized");*/
                    drivers.set(new ChromeDriver(options));

            }
        }

        return drivers.get();
    }
    public static void quitDemoDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }

    }

}


