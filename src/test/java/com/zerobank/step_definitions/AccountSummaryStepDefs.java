package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryStepDefs {

    @When("the user is able to login")
    public void the_user_is_able_to_login() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
    }

    @Then("the user should see page title as {string}")
    public void the_user_should_see_page_title_as(String expectedPageTitle) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        BrowserUtils.waitForClickablility(accountSummaryPage.accountActivityTab, 5);

        Assert.assertEquals(expectedPageTitle, Driver.get().getTitle());
    }

    @Then("the user should be able to see the following account types")
    public void the_user_should_be_able_to_see_the_following_account_types(List<String> expectedAccountTypes) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> actualAccountTypes = new ArrayList<>();

        for (int i = 0; i < accountSummaryPage.accountTypes.size(); i++) {
            actualAccountTypes.add(accountSummaryPage.accountTypes.get(i).getText());
        }
        Assert.assertEquals(expectedAccountTypes, actualAccountTypes);
    }

    @Then("the user should be able to see the following Credit Account columns")
    public void the_user_should_be_able_to_see_the_following_Credit_Account_columns(List<String>expectedCreditAccountColumns) {
        AccountSummaryPage accountSummaryPage= new AccountSummaryPage();
        List<String>actualCreditAccountColumns= new ArrayList<>();

        for (int i = 0; i <accountSummaryPage.creditAccountsColums.size() ; i++) {
          actualCreditAccountColumns.add(accountSummaryPage.creditAccountsColums.get(i).getText());
        }

        Assert.assertEquals(expectedCreditAccountColumns, actualCreditAccountColumns);
    }


}
