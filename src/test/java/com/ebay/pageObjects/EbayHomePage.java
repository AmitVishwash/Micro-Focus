package com.ebay.pageObjects;

import com.ebay.utilities.ActionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHomePage {

    WebDriver driver;
    ActionLibrary actionLibrary = new ActionLibrary();
    public EbayHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[text()='register']")
    public static WebElement registerLink;

    @FindBy(xpath = "//span[@id='gh-ug']//following-sibling::a[text()='Sign in']")
    public static WebElement signInLink;

    public void clickOnSignIn(){
        actionLibrary.clickElement(signInLink);
    }


}
