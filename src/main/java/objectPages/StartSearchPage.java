package objectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

public class StartSearchPage extends BasePage {

    protected static final By TEXT_SEARCH_AREA = By.xpath("//*[@name = 'q']");
    protected static final By BUTTON_GOOGLE_SEARCH_FIRST = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]");
    private static final By BUTTON_GOOGLE_SEARCH_SECOND = By.xpath("//*[@name = 'btnK']");
    private static final By BUTTON_CLOSE_NEW_LOGIN = By.xpath("//*[@id='L2AGLb']");

    public StartSearchPage(WebDriver driver) {
        super(driver);
    }

    public StartSearchPage inputSearchText(String text) {
        if(elementsAttributes.isPresent(BUTTON_CLOSE_NEW_LOGIN)){
            button.btnClick(BUTTON_CLOSE_NEW_LOGIN);
        }
            input.input(TEXT_SEARCH_AREA, text);
        return this;
    }

    public ResultSearchPage resultSearchPagesOpen() {
        try {
            button.btnClick(BUTTON_GOOGLE_SEARCH_FIRST);
        } catch (ElementClickInterceptedException e) {
            button.btnClick(BUTTON_GOOGLE_SEARCH_SECOND);
        }
        return new ResultSearchPage(drManager.getDriver());
    }
}
