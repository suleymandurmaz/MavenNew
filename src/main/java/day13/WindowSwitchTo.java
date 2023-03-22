package day13;

import io.github.bonigarcia.wdm.WebDriverManager;
import odev20230217.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WindowSwitchTo {

    WebDriver driver;
    WebDriverWait wait;

    public WindowSwitchTo(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    String url="https://demoqa.com/browser-windows";
    By lTabButton= By.id("tabButton");
    By lText= By.id("sampleHeading");
    By lwindowButton=By.cssSelector("#windowButton");



    @Test
    public  void switchToWin1(){
        driver.get(url);
        driver.findElement(lTabButton).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String mainWindow=driver.getWindowHandle();
        Set<String> wins=driver.getWindowHandles();


        for (String win: wins){
            if (!win.equalsIgnoreCase(mainWindow)){
                driver.switchTo().window(win);
                break;
            }
        }

        System.out.println(driver.findElement(lText).getText());
        driver.close();//aktif pencereyi kapatıyor.
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));

        /*if (driver.findElements(lText).size()<=0){

        }
        try {
            driver.findElement(lText);
            System.out.println("Hata");
            System.exit(1);
        }catch (Exception ignored){

        }*/

        driver.switchTo().window(mainWindow);
        driver.findElement(lTabButton).click();

        Utils.bekle(2000);
        driver.quit();
    }
    @Test
    public void switchTowin2(){
        driver.get(url);
        driver.findElement(lwindowButton).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String mainWindow=driver.getWindowHandle();
        Set<String> wins=driver.getWindowHandles();

        wins.forEach(a->{
            if (!a.equalsIgnoreCase(mainWindow)){
                driver.switchTo().window(a);

            }
        });

        System.out.println(driver.findElement(lText).getText());
        driver.close();

        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        /*wait.until(driver->{
            if (driver.getWindowHandles().size()==1){
            }
            return true;
        });
*/
        driver.quit();

    }
}
