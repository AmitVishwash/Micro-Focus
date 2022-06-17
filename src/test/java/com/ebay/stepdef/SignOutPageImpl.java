package com.ebay.stepdef;

import com.ebay.pageObjects.SignOutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SignOutPageImpl {
SignOutPage signOutPage  = new SignOutPage(Hooks.driver);
    @And("User clicks on Sign-out button")
    public void userClicksOnSignOutButton() {
        signOutPage.clickSignOutLink();
    }

    @Then("User should be logged out successfully with the message {string}")
    public void userShouldBeLoggedOutSuccessfullyWithTheMessage(String message) {
        signOutPage.checkLogOutPage(message);
    }
}
