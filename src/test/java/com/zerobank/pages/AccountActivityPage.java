package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    public WebElement accountTypes;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']/table/thead/tr/th")
    public List<WebElement> transactionsColumn;

    @FindBy(xpath = "//a[contains(text(), 'Find Transactions')]")
    public WebElement findTransactionsTab;

    @FindBy(id = "aa_fromDate")
    public WebElement dateFrom;

    @FindBy(id = "aa_toDate")
    public WebElement dateTo;

    @FindBy(id= "aa_description")
    public WebElement descriptionBox;

    @FindBy(css = "[type='submit']")
    public WebElement findButton;

    @FindBy (xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    public List<WebElement>transactionDates;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[2]")
    public List<WebElement>descriptionsColumn;

    @FindBy (xpath = "//div[@id='filtered_transactions_for_account']//th[contains(text(),'Date')]")
    public WebElement datesHeader;


    public void getTransactions(String fromDate, String toDate) {
        dateFrom.sendKeys(fromDate);
        dateTo.sendKeys(toDate);
        findButton.click();
    }


    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
