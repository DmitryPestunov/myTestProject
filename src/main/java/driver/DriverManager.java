package driver;

import helpers.Button;
import helpers.ElementsAttributes;
import helpers.Input;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {

    private static final int DEFAULT_IMPL_WAIT_SEC = 15;

    @Getter
    private WebDriver driver;

    @Getter
    private WebDriverWait driverWait;

    @Getter
    private Input input;

    @Getter
    private Button button;

    @Getter
    private ElementsAttributes elAttr;

    @Getter
    private JavascriptExecutor js;

    public DriverManager(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_IMPL_WAIT_SEC));
        this.input = new Input();
        this.js = (JavascriptExecutor) driver;
        this.elAttr = new ElementsAttributes();
        this.button = new Button(driver, driverWait);
    }
}
