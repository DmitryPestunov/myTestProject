package objectPages.testTaskPages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class TestPage extends BasePage {

    Random random;

    @FindBy(xpath = "//*[@class ='rate-table-filter']/form/div/input")
    protected WebElement sellInputArea;
    @FindBy(xpath = "//*[@class ='rate-table-filter']/form/div[3]/input")
    protected WebElement buyInputArea;
    @FindBy(xpath = "//*[@class='js-localization-popover']")
    protected WebElement buttonSelectCountry;
    @FindBy(xpath = "//*[@id='countries-dropdown']")
    protected WebElement selectCountryMenu;
    @FindBy(xpath = "//*[@class = 'flag-icon-small flag-icon-eu']")
    protected WebElement iconEurFlag;
    @FindBy(xpath = "(//*[@class='commercial-rate'])[1]")
    protected WebElement firstBankAmount;
    @FindBy(xpath = "(//*[@class='dropdown-menu'])[1]//li")
    protected List <WebElement> listSelectCounties;
    @FindBy(xpath = "//*[@id='currency-exchange-app']/div/div/div[2]/table/tbody/tr[1]/td[5]/span/span/span[1]")
    protected WebElement currencyFirstBankProvider;
    @FindBy(xpath = "//*[@id='currency-exchange-app']/div/div/div[2]/table/tbody/tr[1]/td[5]/span/span/span[2]")
    protected WebElement displayLossFirstBankProvider;
    @FindBy(xpath = "(//*[@class='btn btn-default form-control ui-select-toggle'])[1]")
    protected WebElement sellButtonSelectCurrency;
    @FindBy(xpath = "(//*[@class='ui-select-choices-row-inner'])[1]")
    protected WebElement firstCurrencyInSelectMenu;

    public TestPage() {
        super();
        random = new Random();
    }

    public WebElement getSellInputArea() {
        return sellInputArea;
    }

    public WebElement getBuyInputArea() {
        return buyInputArea;
    }

    public WebElement getCurrencyFirstBankProvider() {
        return currencyFirstBankProvider;
    }

    public WebElement getFirstDisplayLoss() {
        return displayLossFirstBankProvider;
    }

    public WebElement getSellButtonSelectCurrency() {
        return sellButtonSelectCurrency;
    }

    @Step("input sum into sell area")
    public void inputSellSum(String sum) {
        js.executeScript("arguments[0].scrollIntoView(true);", sellInputArea);
        wait.until(ExpectedConditions.visibilityOf(iconEurFlag));
        sellInputArea.click();
        sellInputArea.clear();
        sellInputArea.sendKeys(sum);
        sellInputArea.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(iconEurFlag));
    }

    @Step("input sum into buy area")
    public void inputBuySum(String sum) {
        js.executeScript("arguments[0].scrollIntoView(true);", buyInputArea);
        wait.until(ExpectedConditions.visibilityOf(iconEurFlag));
        buyInputArea.click();
        buyInputArea.sendKeys(sum);
        buyInputArea.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(iconEurFlag));
    }

    @Step("get value first bank amount in list")
    public String getFirstBankAmount(){
        return firstBankAmount.getText();
    }

    @Step("Change country in footer menu")
    public void changeCountry(){
        js.executeScript("arguments[0].scrollIntoView(true);", buttonSelectCountry);
        buttonSelectCountry.click();
        selectCountryMenu.click();
        listSelectCounties.get(random.nextInt(listSelectCounties.size())).click();
    }

    @Step("Check displayed offer other bank")
    public boolean isOfferOthersBanksDisplayed(){
        try {
            currencyFirstBankProvider.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("change default currency to all")
    public void changeDefaultCurrencyToAll(){
        js.executeScript("arguments[0].scrollIntoView(true);", sellButtonSelectCurrency);
        sellButtonSelectCurrency.click();
        firstCurrencyInSelectMenu.click();
    }
}


