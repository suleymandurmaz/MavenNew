package Selenium.TestNg.Question5.gun8;

import org.testng.annotations.Test;

public class TestParalelel extends TestParalelBase {
    HomePage1 homePage=new HomePage1();
    @Test
    public  void  test1(){
        homePage.gotoUrl();
    }
    @Test
    public  void  test2(){
        homePage.login();

    }
    @Test
    public  void  test3(){
        homePage.logout();

    }

}
