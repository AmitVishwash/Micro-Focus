Feature: New user Registration on Ebay application
  Scenario Outline: New- personal account creation for customers visiting the ebay application
    Given User is on Home Page of Ebay Application
    When User Clicks on Register link on Home Page of Ebay Application
    And User provides First name, Last name, Email and Password as "<firstName>", "<lastName>", "<email>", "<password>"
    Then Create account button should get enabled
    When User Clicks on Create account button
    Then User should be navigated to User Sign-in Page
    And User should see the name displayed

    Examples:
      |firstName|lastName|email                  |password         |
      |Amit     |Verma   |text1889@gmail.com     |12345678a        |


 Scenario Outline: Sign-in verification for already customers on the ebay application
    Given User is on Home Page of Ebay Application
    When User Clicks on Sign-in link on Home Page of Ebay Application
    Then User should land on the Sign-in page with email or username text box displayed
    And User should see continue button enabled
    When User provides "<email>"
    When User Clicks on Continue button
    Then User should be navigated to User Sign-in password page
    And User should see email pre-populated and Sign in button disabled
    When User provides password "<password>"
    Then Sign in button should get enabled
    When User clicks on Sign-in button
    Then User should be navigated to User Signed-In page with profile name displayed as "<profileName>"

    Examples:
    |email                  |password |profileName|
    |text7627@gmail.com     |12345678a|Adam       |

  @1
  Scenario Outline: Sign-out verification for already customers on the ebay application
    Given User is on Home Page of Ebay Application
    When User Clicks on Sign-in link on Home Page of Ebay Application
    Then User should land on the Sign-in page with email or username text box displayed
    When User provides "<email>"
    When User Clicks on Continue button
    Then User should be navigated to User Sign-in password page
    When User provides password "<password>"
    Then Sign in button should get enabled
    When User clicks on Sign-in button
    Then User should be navigated to User Signed-In page with profile name displayed as "<profileName>"
    When User clicks on profile name
    And User clicks on Sign-out button
    Then User should be logged out successfully with the message "<signOutMessage>"

    Examples:
      |email                  |password |profileName|signOutMessage|
      |text7627@gmail.com     |12345678a|Adam       |You've signed out.|

