package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(id = "aa_accountId")
    public WebElement accountTypes;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']/table/thead/tr/th")
    public List<WebElement> transactionsColumn;




    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }
}
