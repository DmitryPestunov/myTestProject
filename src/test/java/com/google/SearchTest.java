package com.google;

import org.testng.annotations.Test;

import java.util.Locale;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    @Test(description = "search weather in Poznan")
    public void searchGoogleTest(){
        var result = resultSearchPage.isResultPresent();
        assertTrue(result);
    }

    @Test(description = "check first link")
    public void checkFirstLinkTest(){
        var result = resultSearchPage.resultSearchPagesOpenFirstLink().isResultPresent();
        assertTrue(result);
        assertThat(brManager.getTitle().toLowerCase(Locale.ROOT)).contains("poznań", "weather");
    }
}
