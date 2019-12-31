package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

@FindBy(id = "user_login")
public WebElement usernameBox;

@FindBy (id= "user_password")
public WebElement passwordBox;

@FindBy(name = "submit")
public WebElement signinBut;

@FindBy(xpath = "//div[@class='alert alert-error']")
public WebElement errorMessage;

    public void login(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        signinBut.click();

    }

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }
}
