package gun09;

import com.google.j2objc.annotations.Weak;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class elementIn {

    WebDriver driver;

    WebDriverWait wait;

    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void element1(){


        driver.get("https://demoqa.com/text-box");

        WebElement element = driver.findElement(By.xpath("(//div[@class='row'])[1]"));

        element.findElement(By.xpath(".//div[2]"));


        driver.quit();


    }

    @Test
    public void form(){
        driver.get("https://demoqa.com/text-box");

        WebElement element = driver.findElement(By.xpath("//form"));

        List<WebElement> elements=driver.findElements(By.xpath(".//input | .//textarea"));

        for (WebElement webElement : elements) {
            System.out.println(webElement.getAttribute("id"));

        }




        driver.quit();

    }
    @Test
    public void deneme2(){
        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.cssSelector("#userName")).sendKeys("Mümin ÖZDAMAR");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("mozzi998@gmail.com");
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Ankara");
        driver.findElement(By.cssSelector("#permanentAddress")).sendKeys("Türkiye");

        driver.findElement(By.xpath("//button[text()='Submit']")).click();


        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("#name"),"Mümin ÖZDAMAR"));

        driver.quit();




    }
    @Test
    public void deneme3(){


  /*      https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html
        js.executeScript("arguments[0].scrollIntoView();", element);
//p[contains(text(),'Curae era')]*/
       driver.get("https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Curae era')]"));


        JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView();",element);

        driver.quit();


    }

}
