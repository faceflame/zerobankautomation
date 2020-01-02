package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class AccountActivityStepDefs {

    @When("the user clicks on Account Activity tab")
    public void the_user_clicks_on_Account_Activity_tab() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        BrowserUtils.waitForClickablility(accountActivityPage.accountActivityTab, 5);
        accountActivityPage.accountActivityTab.click();
    }

    @Then("the page title should be  {string}")
    public void the_page_title_should_be(String expectedPageTitle) {
        Assert.assertEquals(expectedPageTitle, Driver.get().getTitle());
    }

    @Then("the system should display default account type as {string}")
    public void the_system_should_display_default_account_type_as(String expectedDefaultAccountType) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select select = new Select(accountActivityPage.accountTypes);
        String actualDefaultAccountType = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedDefaultAccountType, actualDefaultAccountType);
    }

    @Then("the system should have the following account types available")
    public void the_system_should_have_the_following_account_types_available(List<String> expectedAccountTypes) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select select = new Select(accountActivityPage.accountTypes);
        List<WebElement> actualAccounts = select.getOptions();
        List<String> actualAccountTypes = new ArrayList<>();

        for (int i = 1; i < actualAccounts.size(); i++) {
            actualAccountTypes.add(actualAccounts.get(i).getText());

        }
        Assert.assertEquals(expectedAccountTypes, actualAccountTypes);
    }


    @Then("the system should display the following headers on transactions table")
    public void the_system_should_display_the_following_headers_on_transactions_table(List<String> expectedTableHeaders) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        ArrayList<String>actualTableHeaders= new ArrayList<>();

        for (int i = 0; i <accountActivityPage.transactionsColumn.size() ; i++) {

            Assert.assertEquals(expectedTableHeaders.get(i), accountActivityPage.transactionsColumn.get(i).getText());

        }



    }
}