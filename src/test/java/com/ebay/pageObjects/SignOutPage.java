package com.ebay.pageObjects;

import com.ebay.utilities.ActionLibrary;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOutPage {
    WebDriver driver;

    ActionLibrary actionLibrary = new ActionLibrary();

    public SignOutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }



    @FindBy(xpath = "//h1")
    public WebElement signOutHeadingMessage;

    @FindBy(xpath = "//div[@id='signout-banner-text']/p")
    public WebElement signOutSubHeadingMessage;

    @FindBy(xpath = "//a[text()='Sign out']")
    public WebElement signOutLink;

    @FindBy(id = "signin-link")
    public WebElement signInAgainlink;

    public void clickSignOutLink(){
        actionLibrary.clickElement(signOutLink);
    }

    public void checkLogOutPage(String message) {
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(signOutHeadingMessage));
        System.out.println(actionLibrary.getElementText(signOutHeadingMessage));
        Assert.assertEquals(message,actionLibrary.getElementText(signOutHeadingMessage));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(signOutSubHeadingMessage));
        Assert.assertTrue("Expected - Sign-in again button should be visible but Actual state is :"+actionLibrary.getElementIsDisplayedStatus(signInAgainlink),actionLibrary.getElementIsDisplayedStatus(signInAgainlink));

    }
}
