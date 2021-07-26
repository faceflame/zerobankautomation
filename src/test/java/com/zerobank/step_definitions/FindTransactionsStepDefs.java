package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindTransactionsStepDefs {
    AccountActivityPage accountActivityPage = new AccountActivityPage();


    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {

        accountActivityPage.findTransactionsTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        BrowserUtils.waitForVisibility(accountActivityPage.dateFrom, 5);
        accountActivityPage.dateFrom.sendKeys(fromDate);
        accountActivityPage.dateTo.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        accountActivityPage.findButton.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(2);
        fromDate = fromDate.replace("-", "");
        toDate = toDate.replace("-", "");
        Integer firstDate = Integer.valueOf(fromDate);
        Integer lastDate = Integer.valueOf(toDate);

        List<String> transactions = BrowserUtils.getListOfString(accountActivityPage.transactionDates);
        List<String> transactionsFinal = new ArrayList<>();
        List<Integer> actualTransactionDates = new ArrayList<>();

        for (int i = 0; i < transactions.size(); i++) {
            transactionsFinal.add(transactions.get(i).replace("-", ""));
            actualTransactionDates.add(Integer.valueOf(transactionsFinal.get(i)));
        }
        Assert.assertTrue(actualTransactionDates.get(0) <= lastDate);
        Assert.assertTrue(actualTransactionDates.get(actualTransactionDates.size() - 1) >= 0);

        accountActivityPage.dateFrom.clear();
        accountActivityPage.dateTo.clear();
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<String> actualDates = BrowserUtils.getListOfString(accountActivityPage.transactionDates);
        String value = "";
        String followingValue = "";

        for (int i = 0; i < actualDates.size() - 1; i++) {
            value = actualDates.get(i);
            followingValue = actualDates.get(i + 1);
        }
        Assert.assertTrue(value.compareTo(followingValue) > 0);
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        List<String> actualDates = BrowserUtils.getListOfString(accountActivityPage.transactionDates);
        Assert.assertTrue(!actualDates.contains(string));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        BrowserUtils.waitForVisibility(accountActivityPage.dateFrom, 5);
        accountActivityPage.descriptionBox.sendKeys(description);
        BrowserUtils.waitFor(1);
        accountActivityPage.getTransactions("2012-09-02", "2012-09-06");
        accountActivityPage.descriptionBox.clear();
        accountActivityPage.dateFrom.clear();
        accountActivityPage.dateTo.clear();
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        BrowserUtils.waitFor(1);

        List<String> descriptions = BrowserUtils.getListOfString(accountActivityPage.descriptionsColumn);

        System.out.println(descriptions);
        System.out.println(description);

        for (int i = 0; i < descriptions.size(); i++) {
            Assert.assertTrue(descriptions.get(i).startsWith(description));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        BrowserUtils.waitForVisibility(accountActivityPage.dateFrom, 5);
        List<String> descriptions = BrowserUtils.getListOfString(accountActivityPage.descriptionsColumn);
        Assert.assertTrue(!descriptions.contains(string));
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        List <String> transactions=BrowserUtils.getListOfString(accountActivityPage.depositColumn);
        Assert.assertTrue(transactions.size()>=1);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        List<String>withdrawals= BrowserUtils.getListOfString(accountActivityPage.withdrawalsColumn);
        Assert.assertTrue(withdrawals.size()>=1);

    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        accountActivityPage.type.click();
        Select select= new Select(accountActivityPage.type);
        select.selectByVisibleText(string);
        accountActivityPage.findButton.click();
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {

        Assert.assertTrue(accountActivityPage.withdrawalsColumn.size()==0);
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Assert.assertTrue(accountActivityPage.depositColumn.size()==0);
    }


}
