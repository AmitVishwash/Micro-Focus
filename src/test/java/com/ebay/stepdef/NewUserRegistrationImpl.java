package com.ebay.stepdef;

import com.ebay.pageObjects.EbayHomePage;
import com.ebay.pageObjects.EbaySignInPage;
import com.ebay.pageObjects.EbayUserRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NewUserRegistrationImpl {

    EbayUserRegistrationPage ebayUserRegistrationPage = new EbayUserRegistrationPage(Hooks.driver);
    EbaySignInPage ebaySignInPage = new EbaySignInPage(Hooks.driver);
    EbayHomePage ebayHomePage = new EbayHomePage(Hooks.driver);
    @Given("User is on Home Page of Ebay Application")
    public void user_is_on_home_page_of_ebay_application() {
        ebayUserRegistrationPage.launchApplication();

    }
    @When("User Clicks on Register link on Home Page of Ebay Application")
    public void user_clicks_on_register_link_on_home_page_of_ebay_application() {
       ebayUserRegistrationPage.clickOnRegisterLink();
    }
    @Then("Create account button should get enabled")
    public void create_account_button_should_get_enabled() {
        Assert.assertTrue("Expected- Create account Button Enabled status-true but actual state is "+ ebayUserRegistrationPage.getCreateAccountButtonStatus(), ebayUserRegistrationPage.getCreateAccountButtonStatus());

    }
    @When("User Clicks on Create account button")
    public void user_clicks_on_create_account_button() {
        ebayUserRegistrationPage.clickOnCreateAccountButton();

    }
    @Then("User should be navigated to User Sign-in Page")
    public void user_should_be_navigated_to_user_sign_in_page() {
        ebaySignInPage.isUserSignedInPageDisplayed();

    }
    @Then("User should see the profile name displayed as {string}")
    public void user_should_see_the_profile_name_displayed_as(String profileName) {
        ebaySignInPage.isProfileNameDisplayed(profileName);
    }

    @And("User provides First name, Last name, Email and Password as {string}, {string}, {string}, {string}")
    public void userProvidesFirstNameLastNameEmailAndPasswordAs(String firstName, String lastName, String email, String password) {
        ebayUserRegistrationPage.fillPersonalAccountregistrationDetails(firstName,lastName,email,password);
    }

    @When("User Clicks on Sign-in link on Home Page of Ebay Application")
    public void userClicksOnSignInLinkOnHomePageOfEbayApplication() {
        ebayHomePage.clickOnSignIn();
        try{
            Thread.sleep(15000);
        }catch (Exception e) {
            throw new RuntimeException(new Throwable().getCause());
        }

    }


    @Then("Create account button should be disabled")
    public void createAccountButtonShouldBeDisabled() {
        Assert.assertFalse("Expected- Create account button should be disabled but the Actual state is: "+ebayUserRegistrationPage.getCreateAccountButtonStatus(),ebayUserRegistrationPage.getCreateAccountButtonStatus());
    }

    @And("User should see the generic email error message {string}")
    public void userShouldSeeTheGenericEmailErrorMessage(String errorMessage) {
        ebayUserRegistrationPage.validateRegistrationGenericEmailErrorMessage(errorMessage);
    }

    @And("User should see the generic name error message {string}")
    public void userShouldSeeTheGenericNameErrorMessage(String nameMessage) {
        ebayUserRegistrationPage.validateRegistrationGenericEmailNameMessage(nameMessage);
    }

    @And("User should see the generic password error message {string}")
    public void userShouldSeeTheGenericPasswordErrorMessage(String passwordErrorMessage) {
        ebayUserRegistrationPage.validateRegistrationGenericPasswordMessage(passwordErrorMessage);
    }
}
