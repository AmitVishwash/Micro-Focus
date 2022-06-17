package com.ebay.pageObjects;

import com.ebay.utilities.ActionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayUserRegistrationPage {
    WebDriver driver;
    ActionLibrary actionLibrary = new ActionLibrary();
 public EbayUserRegistrationPage(WebDriver driver){
     this.driver = driver;
     PageFactory.initElements(driver, this);
 }

    @FindBy(id = "firstname")
    public WebElement firstNameTextBox;

    @FindBy(id = "lastname")
    public WebElement lastNameTextBox;

    @FindBy(id = "Email")
    public WebElement emailTextBox;

    @FindBy(id = "password")
    public WebElement passwordTextBox;

    @FindBy(id = "EMAIL_REG_FORM_SUBMIT")
    public WebElement createAccountButton;


    public void clickOnRegisterLink(){
        actionLibrary.clickElement(EbayHomePage.registerLink);

    }

    public void launchApplication() {
        actionLibrary.launchUrl();
    }

    public void fillPersonalAccountregistrationDetails(String firstName, String lastName, String email, String password) {
        actionLibrary.enterText(firstNameTextBox,firstName);
        actionLibrary.enterText(lastNameTextBox,lastName);
        actionLibrary.enterText(emailTextBox,email);
        actionLibrary.enterText(passwordTextBox,password);
    }

    public boolean getCreateAccountButtonStatus(){
        return actionLibrary.getElementIsEnabledStatus(createAccountButton);
    }

    public void clickOnCreateAccountButton() {
        actionLibrary.clickElement(createAccountButton);
    }
}
