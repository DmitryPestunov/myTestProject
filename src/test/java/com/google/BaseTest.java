package com.google;

import driver.BrowserManager;
import driver.DriverManager;
import driver.InitDriver;
import objectPages.BasePage;
import objectPages.FirstLinkInSearch;
import objectPages.ResultSearchPage;
import objectPages.StartSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private WebDriver driver = InitDriver.initDriver();

    protected StartSearchPage startSearchPage;
    protected ResultSearchPage resultSearchPage;
    protected FirstLinkInSearch firstLinkInSearch;
    protected DriverManager drManager;
    protected BrowserManager brManager;

    public BaseTest() {
        managersInit();
        pagesInit();
        brManager.getPage();
    }

    private void managersInit() {
        drManager = new DriverManager(InitDriver.initDriver());
        brManager = new BrowserManager(InitDriver.initDriver());
    }

    private void pagesInit(){
        startSearchPage = new StartSearchPage(driver);
        resultSearchPage = new ResultSearchPage(driver);
        firstLinkInSearch = new FirstLinkInSearch(driver);
    }

    @BeforeMethod
    public void setUp() {
        brManager.getPage();
        startSearchPage.inputSearchText("Weather in Poznan")
                .resultSearchPagesOpen();

    }

    @AfterClass
    public void closeDriver(){
        brManager.quit();
    }
}
