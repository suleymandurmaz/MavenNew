package day15;

import Homework.day13.Base;
import odev20230217.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DragDrop1 extends Base {

    String url="https://demoqa.com/droppable";

    By droppable = By.id("droppable");
    By draggable = By.id("draggable");




    @Test
    public void dragDrop1(){

        WebElement eDraggable = driver.findElement(draggable);
        WebElement eDroppable = driver.findElement(droppable);

        driver.get(url);

           new Actions(driver)
                .moveToElement(eDraggable)
                .clickAndHold(eDraggable)
                .moveToElement(eDroppable)
                .release()
                .build()
                .perform();


        driver.quit();




    }
    @Test
    public void dragDrop2(){

        driver.get(url);

        WebElement eDraggable = driver.findElement(draggable);
        WebElement eDroppable = driver.findElement(droppable);

        new Actions(driver)
                .pause(500)
                .dragAndDrop(eDraggable,eDroppable)
                .build()
                .perform();


        Utils.bekle(3000);
        driver.quit();


    }
}
