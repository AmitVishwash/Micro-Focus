package com.ebay.pageObjects;

import com.ebay.utilities.ActionLibrary;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayUserRegistrationPage {
    WebDriver driver;
    ActionLibrary actionLibrary = new ActionLibrary();

    public  String firstName;
    public  String lastName;
    public  String email;
    public  String password;
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

    @FindBy(xpath = "//span[@id='Email_err']")
    public WebElement emailErrorText;

    @FindBy(xpath = "//span[@id='password_err']")
    public WebElement passwordErrorText;


    @FindBy(xpath = "//span[@id='firstname_err']")
    public WebElement firstNameErrorText;


    @FindBy(xpath = "//span[@id='lastname_err']")
    public WebElement lastNameErrorText;






    public void clickOnRegisterLink(){
        actionLibrary.clickElement(EbayHomePage.registerLink);

    }

    public void launchApplication() {
        actionLibrary.launchUrl();
    }

    public  void fillPersonalAccountregistrationDetails(String firstName, String lastName, String email, String password) {
        actionLibrary.enterText(firstNameTextBox,firstName);
        actionLibrary.enterText(lastNameTextBox,lastName);
        actionLibrary.enterText(emailTextBox,email);
        actionLibrary.enterText(passwordTextBox,password);
        System.out.println(actionLibrary.getElementValue(passwordTextBox));
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;

    }

    public boolean getCreateAccountButtonStatus(){
        return actionLibrary.getElementIsEnabledStatus(createAccountButton);
    }

    public void clickOnCreateAccountButton() {
        actionLibrary.clickElement(createAccountButton);
    }

    public void validateRegistrationGenericEmailErrorMessage(String errorMessage) {
            Assert.assertEquals(errorMessage,actionLibrary.getElementText(emailErrorText));
    }

    public void validateRegistrationGenericEmailNameMessage(String nameMessage) {
        if(lastName.equalsIgnoreCase("")&& firstName.equalsIgnoreCase(firstName)){
            Assert.assertEquals(nameMessage,actionLibrary.getElementText(lastNameErrorText));
        }
        else {
            Assert.assertEquals(nameMessage,actionLibrary.getElementText(firstNameErrorText));
        }

    }

    public void validateRegistrationGenericPasswordMessage(String passwordErrorMessage) {

            Assert.assertEquals(passwordErrorMessage,actionLibrary.getElementText(passwordErrorText));
    }
}
