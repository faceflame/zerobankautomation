package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

public class PayBillsStepDefs {

    @When("the user clicks on Pay Bills tab")
    public void the_user_clicks_on_Pay_Bills_tab() {

        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payBillstab.click();

    }

    @When("the user completes a successful Pay operation")
    public void the_user_completes_a_successful_Pay_operation() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.makePay("10000", "2020-01-02", "January rent");
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedPaymentMessagge) {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitForVisibility(payBillsPage.paymentMessagge, 5);
        String actualPaymentMessage = payBillsPage.paymentMessagge.getText();
        Assert.assertEquals(expectedPaymentMessagge, actualPaymentMessage);
    }

    @When("the user fails to enter valid amount")
    public void the_user_fails_to_enter_valid_amount() {
        PayBillsPage payBillsPage = new PayBillsPage();
        Select select= new Select(payBillsPage.payee);
        Select select1= new Select(payBillsPage.account);
        select.selectByVisibleText("Bank of America");
        select1.selectByVisibleText("Checking");

        payBillsPage.date.sendKeys("2020-01-28");
        payBillsPage.description.sendKeys("Para");
        payBillsPage.payButton.click();

    }

    @When("the user fails to enter valid date")
    public void the_user_fails_to_enter_valid_date() {
        /*PayBillsPage payBillsPage = new PayBillsPage();
        Select select= new Select(payBillsPage.payee);
        Select select1= new Select(payBillsPage.account);
        select.selectByVisibleText("Bank of America");
        select1.selectByVisibleText("Checking");
        payBillsPage.amount.sendKeys("23566");
        payBillsPage.description.sendKeys("Para");
        payBillsPage.payButton.click();
*/
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String string) {
        BrowserUtils.waitFor(3);
        Alert alert = Driver.get().switchTo().alert();
        BrowserUtils.waitFor(3);
        Assert.assertEquals(string, alert.getText());



    }


}
