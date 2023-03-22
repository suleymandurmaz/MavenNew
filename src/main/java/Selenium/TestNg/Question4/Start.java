package Selenium.TestNg.Question4;

import org.testng.annotations.Test;

public class Start extends StartBase{

    @Test(priority = 0)
    public void open1(){

        open();
    }
    @Test(priority = 1)
    public void login1(){
        login();

    }
    @Test(priority = 2)
    public void admin1(){
        adnin();
    }
}
