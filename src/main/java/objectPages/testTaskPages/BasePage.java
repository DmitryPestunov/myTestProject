package objectPages.testTaskPages;


import driver.InitDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final String URL = "https://www.paysera.pl/v2/en-PL/fees/currency-conversion-calculator#/";
    public static JavascriptExecutor js;

    public BasePage() {
        this.driver = InitDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }


    public void openPage(){
        driver.get(URL);
    }

    public void quit(){
        driver.quit();
    }

}
