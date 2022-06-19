package com.ebay.stepdef;

import com.ebay.pageObjects.EbaySignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignInPageImpl {

    EbaySignInPage ebaySignInPage = new EbaySignInPage(Hooks.driver);
    @Then("User should land on the Sign-in page with email or username text box displayed")
    public void userShouldLandOnTheSignInPageWithEmailOrUsernameTextBoxDisplayed() {
        ebaySignInPage.isSignInPageDisplayed();
    }

    @When("User provides {string}")
    public void userProvides(String email) {
        ebaySignInPage.enterEmail(email);
    }

    @And("User should see continue button disabled")
    public void userShouldSeeContinueButtonDisabled() {
        Assert.assertFalse("Expected- Continue button should be disabled but Actual state is: "+ebaySignInPage.getContinueButtonEnabledStatus(),ebaySignInPage.getContinueButtonEnabledStatus());
    }

    @And("User Clicks on Continue button")
    public void userClicksOnContinueButton() {
        ebaySignInPage.clickOnContinueButton();
    }

    @And("User should see continue button enabled")
    public void userShouldSeeContinueButtonEnabled() {
        Assert.assertTrue("Expected- Continue button should be enabled but Actual state is: "+ebaySignInPage.getContinueButtonEnabledStatus(),ebaySignInPage.getContinueButtonEnabledStatus());
    }

    @Then("User should be navigated to User Sign-in password page")
    public void userShouldBeNavigatedToUserSignInPasswordPage() {
        ebaySignInPage.isSignInPasswordPageDisplayed();
    }

    @And("User should see email pre-populated and Sign in button disabled")
    public void userShouldSeeEmailPrePopulatedAndSignInButtonDisabled() {
        Assert.assertEquals(EbaySignInPage.emailValue,ebaySignInPage.checkEmailFieldvalue());
        Assert.assertFalse("Expected- Sign-in button should be disabled but Actual state is: "+ebaySignInPage.getSignInButtonEnabledStatus(),ebaySignInPage.getSignInButtonEnabledStatus());
    }

    @When("User provides password {string}")
    public void userProvidesPassword(String password) {
        ebaySignInPage.enterPasword(password);
    }

    @Then("Sign in button should get enabled")
    public void signInButtonShouldGetEnabled() {
        Assert.assertTrue("Expected- Sign in button should be enabled but Actual state is: "+ebaySignInPage.getSignInButtonEnabledStatus(),ebaySignInPage.getSignInButtonEnabledStatus());
    }

    @When("User clicks on Sign-in button")
    public void userClicksOnSignInButton() {
        ebaySignInPage.clickonSignInButton();
    }

    @Then("User should be navigated to User Signed-In page with profile name displayed as {string}")
    public void userShouldBeNavigatedToUserSignedInPageWithProfileNameDisplayedAs(String profileName) {
        ebaySignInPage.isProfileNameDisplayed(profileName);
        ebaySignInPage.isUserSignedInPageDisplayed();
    }

    @When("User clicks on profile name")
    public void userClicksOnProfileName() {
        ebaySignInPage.clickOnProfileName();
    }


    @Then("User should see password error message {string}")
    public void userShouldSeePasswordErrorMessage(String errorMessage) {
        ebaySignInPage.checkPasswordErrorMesaage(errorMessage);
    }
}
