package objectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstLinkInSearch extends BasePage{

    private static final By PAGE = By.xpath("//*[@class = 'accuweather']");

    public FirstLinkInSearch(WebDriver driver) {
        super(driver);
    }

    public boolean isResultPresent() {
        return elementsAttributes.isPresent(PAGE);
    }



}
