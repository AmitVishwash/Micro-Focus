package com.ebay.utilities;

import com.ebay.stepdef.Hooks;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionLibrary {
    LoggerUtility loggerUtility = new LoggerUtility();

    WebDriverWait webDriverWait= new WebDriverWait(Hooks.driver,15);;

    public void clickElement(WebElement element){

        webDriverWait.until(ExpectedConditions.visibilityOf(element)).click();
        loggerUtility.logInfo("element {} is clicked ");


    }

    public void launchUrl() {
        Hooks.driver.get(ReadConfigValues.getProperty("hostUrl"));
        loggerUtility.logInfo("Url is launched and the current Url is "+Hooks.driver.getCurrentUrl());

    }

    public void enterText(WebElement element, String value) {
        if(webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()){
            element.sendKeys(value);
        }else{
            throw new ElementNotVisibleException("Element is not visible:"+ new Throwable().getCause());
        }

    }

    public boolean getElementIsEnabledStatus(WebElement element) {
        boolean status = false;
        if (webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()){
            try {
                Thread.sleep(2000);
                 status =  element.isEnabled();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return status;
        }
        else {
            throw new ElementNotVisibleException("Element is not visible:" + new Throwable().getCause());
        }

    }

    public boolean getElementIsDisplayedStatus(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

    }

    public String getElementValue(WebElement element) {

        return webDriverWait.until(ExpectedConditions.visibilityOf(element)).getAttribute("value");
    }

    public String getElementText(WebElement element) {
        if (webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()){
            return element.getText();
        }
        else {
            throw new ElementNotVisibleException(new Throwable().getMessage());
        }
    }
}