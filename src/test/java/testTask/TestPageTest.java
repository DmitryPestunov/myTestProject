package testTask;

import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TestPageTest extends BaseTestClass {

    @Test(description = "Amount box emptying test")
    public void amountBoxTest() {
        testPage.inputSellSum("123");

        assertThat(testPage.getSellInputArea().getAttribute("class"))
                .withFailMessage("Class's name must contains \"ng-not-empty\"").contains("ng-not-empty");
        assertThat(testPage.getBuyInputArea().getAttribute("class"))
                .withFailMessage("Class's name must contains \"ng-empty\"").contains("ng-empty");

        testPage.inputBuySum("321");

        assertThat(testPage.getSellInputArea().getAttribute("class"))
                .withFailMessage("Class's name must contains \"ng-empty\"").contains("ng-empty");
        assertThat(testPage.getBuyInputArea().getAttribute("class"))
                .withFailMessage("Class's name must contains \"ng-not-empty\"").contains("ng-not-empty");
    }

    @Test(description = "Changes country")
    public void pageChangeCountryTest() {
        String valueBefore = testPage.getFirstBankAmount();

        testPage.changeCountry();

        String valueAfter = testPage.getFirstBankAmount();

        assertThat(valueBefore).withFailMessage("values must be not equals").isNotEqualTo(valueAfter);
    }

    @Test(description = "change to default currency test")
    public void changeToDefaultCurrencyTest(){
        testPage.changeDefaultCurrencyToAll();
        assertThat(testPage.getSellButtonSelectCurrency().getText()).isEqualTo("All");

        testPage.changeCountry();

        assertThat(testPage.getSellButtonSelectCurrency().getText()).isNotEqualTo("All");
    }

    @Test(description = "display loss test")
    public void displayLossTest() {
        testPage.changeCountry();

        if (testPage.isOfferOthersBanksDisplayed()) {
            float amountOurBank = Float.parseFloat(testPage.getFirstBankAmount())*100;
            float currencyFirstBankProvider = Float.parseFloat(testPage.getCurrencyFirstBankProvider().getText())*100;
            float displayLoss = Float.parseFloat(testPage.getFirstDisplayLoss().getText()
                    .replaceAll("[()]", ""))*100;

            assertThat(displayLoss).isEqualTo(currencyFirstBankProvider - amountOurBank);
        } else {
            assertThat(true);
        }
    }
}