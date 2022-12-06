package objectPages;

import driver.BrowserManager;
import driver.DriverManager;
import helpers.Button;
import helpers.ElementsAttributes;
import helpers.Input;
import org.openqa.selenium.WebDriver;


public class BasePage {
    protected DriverManager drManager;
    protected BrowserManager brManager;
    protected Input input;
    protected Button button;
    protected ElementsAttributes elementsAttributes;

    public BasePage(WebDriver driver) {
        this.drManager = new DriverManager(driver);
        this.brManager = new BrowserManager(driver);
        this.input = drManager.getInput();
        this.button = drManager.getButton();
        this.elementsAttributes = drManager.getElAttr();
    }

    private BasePage(){
    }

}
