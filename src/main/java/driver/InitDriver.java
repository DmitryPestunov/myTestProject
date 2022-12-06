package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitDriver {
    private static WebDriver driver;

    private InitDriver() {
    }

    public static WebDriver initDriver() {
        if (driver == null) {
            createDriver();
            return driver;
        }
        return driver;
    }

    private static void createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
}
