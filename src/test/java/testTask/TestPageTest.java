package testTask;

import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TestPageTest extends BaseTestClass {

    @Test(description = "Amount box emptying test")
    public void amountBoxTest() {
        testPage.inputSellSum("123");

        assertThat(testPage.getSellInputArea().getAttribute("class")).contains("ng-not-empty");
        assertThat(testPage.getBuyInputArea().getAttribute("class")).contains("ng-empty");

        testPage.inputBuySum("321");

        assertThat(testPage.getSellInputArea().getAttribute("class")).contains("ng-empty");
        assertThat(testPage.getBuyInputArea().getAttribute("class")).contains("ng-not-empty");
    }
}
