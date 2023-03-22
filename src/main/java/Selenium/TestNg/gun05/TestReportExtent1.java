package Selenium.TestNg.gun05;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestReportExtent1 {

    ExtentSparkReporter html;
    ExtentReports extentReports;
    ExtentTest test1;
    ExtentTest test2;
    ExtentTest test3;

    @BeforeTest
    public void setup() {
        html = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(html);
        test1 = extentReports.createTest("Test 1", "Test-Tanimi-1 ");
        test2 = extentReports.createTest("Test 2", "Test-Tanimi-2 ");
        test3 = extentReports.createTest("Test 3", "Test-Tanimi-3 ");


    }

    @AfterTest
    public void tearDown() {
        extentReports.setSystemInfo("Tester", "Mümin");
        extentReports.setSystemInfo("Os", System.getProperty("os.name"));
        extentReports.setSystemInfo("Project Dir", System.getProperty("user.dir"));
        extentReports.flush();

    }

    @Test
    public void test1() {
        test1.info("Test1 basladi");
        try {
            Assert.assertEquals(1, 1);
            test1.pass("Passed");
        } catch (AssertionError e) {
            test1.fail("Test1 failed"+e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2() {
        test1.info("Test2 basladi");
        try {
            Assert.assertEquals(1, 2);
            test2.fail("Test2 passed");
        } catch (AssertionError e) {
            test1.fail("Test2 failed"+e.getMessage());
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void test3() {
        test1.info("Test3 basladi");
        try {
            Assert.assertEquals(1, 1);
            test3.pass("Test 3 passed");
        } catch (Exception e) {
            test1.fail("Test3 failed"+e.getMessage());
            Assert.fail(e.getMessage());
        }
    }
}
