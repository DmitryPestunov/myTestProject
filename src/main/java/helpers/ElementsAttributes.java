package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class ElementsAttributes extends Elements{

    public boolean isPresent(By locator) {
        try {
            return waitUntilExist(locator) != null;
        } catch (TimeoutException ex) {
            return false;
        }
    }
}
