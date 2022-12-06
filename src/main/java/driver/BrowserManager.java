package driver;


import org.openqa.selenium.WebDriver;

public class BrowserManager {
    private static final String URL = "https://www.google.com";
    private WebDriver driver;
    private DriverManager drManager;

    public BrowserManager(WebDriver driver) {
        this.driver = driver;
        this.drManager = new DriverManager(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void getPage() {
        drManager.getDriver().get(URL);
    }

    public void quit() {
        drManager.getDriver().quit();
    }
}
