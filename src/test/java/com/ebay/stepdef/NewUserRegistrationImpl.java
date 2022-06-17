package com.ebay.stepdef;

import com.ebay.pageObjects.EbayHomePage;
import com.ebay.pageObjects.EbayUserRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NewUserRegistrationImpl {

    EbayUserRegistrationPage ebayUserRegistrationPage = new EbayUserRegistrationPage(Hooks.driver);
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

    }
    @Then("User should see the name displayed")
    public void user_should_see_the_name_displayed() {

    }

    @And("User provides First name, Last name, Email and Password as {string}, {string}, {string}, {string}")
    public void userProvidesFirstNameLastNameEmailAndPasswordAs(String firstName, String lastName, String email, String password) {
        ebayUserRegistrationPage.fillPersonalAccountregistrationDetails(firstName,lastName,email,password);
    }

    @When("User Clicks on Sign-in link on Home Page of Ebay Application")
    public void userClicksOnSignInLinkOnHomePageOfEbayApplication() {
        ebayHomePage.clickOnSignIn();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
