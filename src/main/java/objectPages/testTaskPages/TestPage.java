package objectPages.testTaskPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestPage extends BasePage {

    @FindBy(xpath = "//*[@class ='rate-table-filter']/form/div/input")
    protected WebElement sellInputArea;
    @FindBy(xpath = "//*[@class ='rate-table-filter']/form/div[3]/input")
    protected WebElement buyInputArea;
    @FindBy(xpath = "(//*[@data-ng-bind = '$select.selected'][1])[last()-1]")
    protected WebElement firstCurrency;
    @FindBy(xpath = "(//*[@data-ng-bind = '$select.selected'][1])[last()]")
    protected WebElement secondCurrency;
    @FindBy(xpath = "//*[@class='js-localization-popover']")
    protected WebElement buttonSelectCountry;
    @FindBy(xpath = "//*[@id='countries-dropdown']")
    protected WebElement selectCountryMenu;
    @FindBy(xpath = "//*[@aria-labelledby='countries-dropdown']")
    protected WebElement countriesDropdown;
    @FindBy(xpath = "//*[@aria-labelledby='languages-dropdown']")
    protected WebElement languageDropdown;
    @FindBy(xpath = "//*[@data-title='mBank amount']/span/span[1]/span[2]/br")
    protected WebElement lossDisplay;
    @FindBy(xpath = "//*[@class = 'flag-icon-small flag-icon-eu']")
    protected WebElement iconEurFlag;

    public WebElement getSellInputArea() {
        return sellInputArea;
    }

    public WebElement getBuyInputArea() {
        return buyInputArea;
    }

    public TestPage() {
        super();
    }

    public void inputSellSum(String sum) {
        js.executeScript("arguments[0].scrollIntoView(true);", sellInputArea);
        wait.until(ExpectedConditions.visibilityOf(iconEurFlag));
        sellInputArea.click();
        sellInputArea.clear();
        sellInputArea.sendKeys(sum);
        sellInputArea.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(iconEurFlag));
    }

    public void inputBuySum(String sum) {
        js.executeScript("arguments[0].scrollIntoView(true);", buyInputArea);
        wait.until(ExpectedConditions.visibilityOf(iconEurFlag));
        buyInputArea.click();
        buyInputArea.sendKeys(sum);
        buyInputArea.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(iconEurFlag));
    }
}


