package testTask;

import driver.InitDriver;
import objectPages.testTaskPages.TestPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeMethod;


public class BaseTestClass {
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected TestPage testPage;



    public BaseTestClass() {
        js = (JavascriptExecutor) InitDriver.getDriver();
        testPage = new TestPage();
    }

    @BeforeMethod
    public void setUp() {
        testPage.openPage();
    }

    @AfterClass
    public void closeDriver() {
        testPage.quit();
    }
}
