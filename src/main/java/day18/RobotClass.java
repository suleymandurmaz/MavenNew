package day18;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class RobotClass{
        WebDriver driver;
        WebDriverWait wait;

        {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        @Test
        public void aut(){
                driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        }

        @Test
        public void deneme(){
                driver.get("https://the-internet.herokuapp.com/basic_auth");

                try {
                        Robot robot=new Robot();
                        robot.keyPress(KeyEvent.VK_A);
                        robot.keyPress(KeyEvent.VK_D);
                        robot.keyPress(KeyEvent.VK_M);
                        robot.keyPress(KeyEvent.VK_I);
                        robot.keyPress(KeyEvent.VK_N);
                        robot.keyPress(KeyEvent.VK_TAB);
                        robot.keyPress(KeyEvent.VK_A);
                        robot.keyPress(KeyEvent.VK_D);
                        robot.keyPress(KeyEvent.VK_M);
                        robot.keyPress(KeyEvent.VK_I);
                        robot.keyPress(KeyEvent.VK_N);
                        robot.keyPress(KeyEvent.VK_TAB);
                        robot.keyPress(KeyEvent.VK_ENTER);
                } catch (AWTException e) {
                        throw new RuntimeException(e);
                }


        }


}
