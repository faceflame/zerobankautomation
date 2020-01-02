package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage extends BasePage{

    @FindBy(id = "sp_payee")
    public WebElement payee;

    @FindBy(id = "sp_account")
    public WebElement account;

    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id="sp_date")
    public WebElement date;

    @FindBy(id ="sp_description")
    public WebElement description;

    @FindBy(id="pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//div[@id='alert_content']/span")
    public WebElement paymentMessagge;

    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    public void makePay(String amount, String date, String description){
        PayBillsPage payBillsPage= new PayBillsPage();
        Select select= new Select(payee);
        Select select1= new Select(account);
        select.getFirstSelectedOption();
        select1.getFirstSelectedOption();
        payBillsPage.amount.sendKeys(amount);
        payBillsPage.date.sendKeys(date);
        payBillsPage.description.sendKeys(description);
        payBillsPage.payButton.click();

    }

}
