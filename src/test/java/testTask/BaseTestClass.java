package testTask;

import driver.InitDriver;
import objectPages.testTaskPages.TestPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTestClass {
    protected JavascriptExecutor js;
    protected TestPage testPage;

    public BaseTestClass() {
        js = (JavascriptExecutor) InitDriver.getDriver();
        testPage = new TestPage();
    }

    @BeforeClass
    public void setUp() {
        testPage.openPage();
    }

    @AfterClass
    public void closeDriver() {
        InitDriver.quitDriver();
    }
}
