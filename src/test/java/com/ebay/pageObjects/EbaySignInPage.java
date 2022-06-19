package com.ebay.pageObjects;

import com.ebay.utilities.ActionLibrary;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbaySignInPage {
    public WebDriver driver;
    public static String emailValue;
    ActionLibrary actionLibrary = new ActionLibrary();
    public EbaySignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    @FindBy(xpath = "//h1")
    public WebElement mainHeading;

        @FindBy(id = "signin-reg-msg")
    public WebElement subHeading;

    @FindBy(id="userid")
    public WebElement emailTextBox;

    @FindBy(id="signin-continue-btn")
    public WebElement continueButton;

    @FindBy(id="signin_fb_btn")
    public WebElement continueWithFacebookButton;

    @FindBy(id="signin_ggl_btn")
    public WebElement continueWithGoogleButton;

    @FindBy(id="signin_appl_btn")
    public WebElement continueWithAppleButton;

    @FindBy(id="user-info")
    public WebElement userEmailField;

    @FindBy(id="switch-account-link")
    public WebElement switchAccountLink;

    @FindBy(xpath="//input[@id='pass']")
    public WebElement passwordTextBox;

    @FindBy(id="sgnBt")
    public WebElement signInButton;

    @FindBy(id="need-help-signin-link")
    public WebElement needHelpSigningLink;


    @FindBy(xpath="//button[@id='gh-ug']")
    public WebElement signedInProfileName;

    @FindBy(xpath="//a[text()=' Daily Deals']")
    public WebElement dailyDealsMenuBar;

    @FindBy(xpath="//a[text()=' Brand Outlet']")
    public WebElement brandOutletMenuBar;

    @FindBy(xpath="//a[text()=' Help & Contact']")
    public WebElement helpContactMenuBar;

    @FindBy(xpath="//a[text()=' Sell']")
    public WebElement sellMenuBar;

    @FindBy(xpath="//a[text()='Watchlist']")
    public WebElement watchListMenuBar;

    @FindBy(xpath="//a[text()='My eBay']")
    public WebElement myEbayMenuBar;

    @FindBy(xpath="//i[text()='Notification']")
    public WebElement notificationBellIcon;

    @FindBy(xpath="//a[@aria-label='Your shopping cart']")
    public WebElement shoppingCartIcon;

    @FindBy(xpath="//input[@value='Search']")
    public WebElement searchButton;

    @FindBy(xpath="//input[@aria-label='Search for anything']")
    public WebElement searchForAnythingTextBox;


    @FindBy(xpath="//p[@id='errormsg']")
    public WebElement pwdErrorMessage;




    public void isSignInPageDisplayed(){

        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(mainHeading));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(subHeading));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(continueButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(continueWithFacebookButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(continueWithGoogleButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(continueWithAppleButton));


    }


    public void enterEmail(String email) {
        actionLibrary.enterText(emailTextBox,email);
        getTextBoxValue();
    }

    public String getTextBoxValue(){
        emailValue=actionLibrary.getElementValue(emailTextBox);
        return emailValue;
    }

    public boolean getContinueButtonEnabledStatus(){
        return actionLibrary.getElementIsEnabledStatus(continueButton);
    }

    public void clickOnContinueButton() {
        actionLibrary.clickElement(continueButton);
    }

    public void isSignInPasswordPageDisplayed() {
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(mainHeading));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(userEmailField));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(passwordTextBox));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(signInButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(needHelpSigningLink));
    }

    public String checkEmailFieldvalue() {
        return actionLibrary.getElementText(userEmailField);
    }

    public boolean getSignInButtonEnabledStatus() {
        return actionLibrary.getElementIsEnabledStatus(signInButton);
    }

    public void enterPasword(String password) {
        actionLibrary.enterText(passwordTextBox,password);
    }

    public void clickonSignInButton() {
        actionLibrary.clickElement(signInButton);
    }

    public void isUserSignedInPageDisplayed() {

        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(dailyDealsMenuBar));
        //Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(brandOutletMenuBar));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(helpContactMenuBar));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(sellMenuBar));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(watchListMenuBar));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(myEbayMenuBar));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(notificationBellIcon));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(shoppingCartIcon));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(searchForAnythingTextBox));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(searchButton));
    }

    public void isProfileNameDisplayed(String profileName) {
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(signedInProfileName));
        System.out.println(actionLibrary.getElementText(signedInProfileName));
        Assert.assertEquals("Hi "+profileName+"!",actionLibrary.getElementText(signedInProfileName));
    }

    public void clickOnProfileName() {
        actionLibrary.clickElement(signedInProfileName);
    }

    public void checkPasswordErrorMesaage(String errorMessage) {
        Assert.assertEquals(errorMessage,actionLibrary.getElementText(pwdErrorMessage));
    }
}
