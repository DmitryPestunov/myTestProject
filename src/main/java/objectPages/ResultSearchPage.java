package objectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultSearchPage extends BasePage{

    private static final By DESCRIPTION_FIRST_LINK = By.xpath("(//*[@class='VwiC3b yXK7lf MUxGbd yDYNvb lyLwlc lEBKkf'])[1]/span");
    private static final By FIRST_LINK = By.xpath("(//*[@class='yuRUbf'])[1]/a");

    public ResultSearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isResultPresent() {
        return elementsAttributes.isPresent(FIRST_LINK);
    }

    public FirstLinkInSearch resultSearchPagesOpenFirstLink() {
        button.btnClick(FIRST_LINK);
        return new FirstLinkInSearch(drManager.getDriver());
    }
}
