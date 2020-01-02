package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationStepDefs {

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage= new AccountSummaryPage();
        accountSummaryPage.savingsLink.click();
    }

    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {
        AccountActivityPage accountActivityPage= new AccountActivityPage();
        Select select= new Select(accountActivityPage.accountTypes);
        Assert.assertEquals("Savings", select.getFirstSelectedOption().getText());
    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage= new AccountSummaryPage();
        accountSummaryPage.brokerageLink.click();
    }

    @Then("Account dropdown should have Brokerage selected")
    public void account_dropdown_should_have_Brokerage_selected() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select select= new Select(accountActivityPage.accountTypes);
        Assert.assertEquals("Brokerage", select.getFirstSelectedOption().getText());
    }
    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage= new AccountSummaryPage();
        accountSummaryPage.checkingAccountLink.click();
   }

    @Then("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {
        AccountActivityPage accountActivityPage= new AccountActivityPage();
        Select select= new Select(accountActivityPage.accountTypes);
        Assert.assertEquals("Checking", select.getFirstSelectedOption().getText());

    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage= new AccountSummaryPage();
        accountSummaryPage.creditCardLink.click();
    }

    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        AccountActivityPage accountActivityPage= new AccountActivityPage();
        Select select= new Select(accountActivityPage.accountTypes);
        Assert.assertEquals("Credit Card", select.getFirstSelectedOption().getText());
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage= new AccountSummaryPage();
        accountSummaryPage.LoanLink.click();
    }

    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        AccountActivityPage accountActivityPage= new AccountActivityPage();
        Select select = new Select(accountActivityPage.accountTypes);
        Assert.assertEquals("Loan", select.getFirstSelectedOption().getText());
    }



}
