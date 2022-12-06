package helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Input extends Elements{

    @Step("Insert [{text}] to input field [{locator}]]")
    public void input(By locator, String text) {
        waitUntilClickable(locator).sendKeys(text);
    }

}
