package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String expectedPageTitle = "Zero - Log in";
        Assert.assertEquals(expectedPageTitle, Driver.get().getTitle());

    }

    @When("the user enters valid login credentials")
    public void the_user_enters_valid_login_credentials() {
        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitForVisibility(loginPage.usernameBox,5);
        loginPage.login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitForClickablility(loginPage.accountSummaryTab, 5);
        String expectedPageTitle = "Zero - Account Summary";
        Assert.assertEquals(expectedPageTitle, Driver.get().getTitle());
    }

    @When("the user enters invalid login credentials")
    public void the_user_enters_invalid_login_credentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("username"), "password1");
    }

    @Then("the system should display {string}")
    public void the_system_should_display(String errorMessage) {
        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitForClickablility(loginPage.errorMessage, 5);
        Assert.assertEquals(errorMessage, loginPage.errorMessage.getText());
    }

    @When("the user enters blank login credentials")
    public void the_user_enters_blank_login_credentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("","");

    }


}
