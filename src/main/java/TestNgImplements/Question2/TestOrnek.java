package TestNgImplements.Question2;

import org.testng.annotations.Test;

public class TestOrnek extends TestOrnekBase{

    @Test
    public void loginTest(){
        login();
    }

    @Test
    public void admin(){
        adminAssert();
    }

}
