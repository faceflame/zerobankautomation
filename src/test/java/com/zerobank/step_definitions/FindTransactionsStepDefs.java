package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindTransactionsStepDefs {
    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.findTransactionsTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        BrowserUtils.waitForVisibility(accountActivityPage.dateFrom, 5);
        accountActivityPage.dateFrom.sendKeys(fromDate);
        accountActivityPage.dateTo.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.findButton.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(2);
        fromDate= fromDate.replace("-", "");
        toDate=toDate.replace("-", "");
        Integer firstDate= Integer.valueOf(fromDate);
        Integer lastDate= Integer.valueOf(toDate);

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> transactions = BrowserUtils.getListOfString(accountActivityPage.transactionDates);
        List<String> transactionsFinal = new ArrayList<>();
        List<Integer> actualTransactionDates = new ArrayList<>();

        for (int i = 0; i < transactions.size(); i++) {
            transactionsFinal.add(transactions.get(i).replace("-", ""));
            actualTransactionDates.add(Integer.valueOf(transactionsFinal.get(i)));
        }

        Assert.assertTrue(actualTransactionDates.get(0)<=lastDate);
        Assert.assertTrue(actualTransactionDates.get(actualTransactionDates.size()-1)>=0);


        accountActivityPage.dateFrom.clear();
        accountActivityPage.dateTo.clear();

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> actualDates = BrowserUtils.getListOfString(accountActivityPage.transactionDates);
        String value= "";
        String followingValue="";

        for (int i = 0; i <actualDates.size()-1 ; i++) {
            value= actualDates.get(i);
            followingValue=actualDates.get(i+1);
        }
        Assert.assertTrue(value.compareTo(followingValue)>0);
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> actualDates = BrowserUtils.getListOfString(accountActivityPage.transactionDates);
        Assert.assertTrue(!actualDates.contains(string));
    }
}
