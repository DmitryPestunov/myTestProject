package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InitDriver {
    public static WebDriver driver;

    private InitDriver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
            return driver;
        }
        return driver;
    }

    private static void createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments(Property)
        driver = new ChromeDriver();
    }

    public static void quitDriver(){
        if(driver !=null){
            driver.quit();
        }
    }

}
