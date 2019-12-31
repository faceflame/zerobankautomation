package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(className = "board-header")
    public List<WebElement>accountTypes;

    @FindBy(xpath = "(//div[@class='board-content'])[3]//table/thead/tr/th")
    public List<WebElement>creditAccountsColums;



    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }
}
