package TestNgImplements.Question3;

import org.testng.annotations.Test;

public class ProgressBar extends ProgressBarBase{


    @Test(priority = 0)
    public void test1(){
        open();
    }
    @Test(priority = 1,dependsOnMethods = "test1")
    public void test2(){
        yuzdeStop();

    }
}
