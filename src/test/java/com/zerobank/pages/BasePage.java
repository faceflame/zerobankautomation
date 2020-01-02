package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    @FindBy(id = "account_summary_tab")
    public WebElement accountSummaryTab;

    @FindBy(id = "account_activity_tab")
    public WebElement accountActivityTab;

    @FindBy(id = "transfer_funds_tab")
    public WebElement transferFundsTab;

    @FindBy(id="pay_bills_tab")
    public WebElement payBillstab;

    @FindBy(id= "money_map_tab")
    public WebElement moneyMapTab;

    @FindBy(id="online_statements_tab")
    public WebElement onlineStatementsTab;




public BasePage(){
    PageFactory.initElements(Driver.get(), this);
}
}


