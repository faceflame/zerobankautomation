package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityStepDefs {
    @Then("the page title should be  {string}")
    public void the_page_title_should_be(String expectedPageTitle) {
        AccountActivityPage accountActivityPage= new AccountActivityPage();
        BrowserUtils.waitForClickablility(accountActivityPage.accountActivityTab,5);
        accountActivityPage.accountActivityTab.click();
        Assert.assertEquals(expectedPageTitle, Driver.get().getTitle());



    }


}
