@accounts_activity_navigation
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is able to login

  @savings_account_redirect
  Scenario: Savings account redirect
    When the user clicks on Savings link on the Account Summary page
    Then the page title should be  "Zero - Account Activity"
    And Account drop down should have Savings selected

  @brokerage_account_redirect
  Scenario: Brokerage account redirect
    When the user clicks on Brokerage link on the Account Summary page
    Then the page title should be  "Zero - Account Activity"
    And Account dropdown should have Brokerage selected

  @checking_account_redirect
  Scenario: Checking account redirect
    When the user clicks on Checking link on the Account Summary page
    Then the page title should be  "Zero - Account Activity"
    And Account drop down should have Checking selected

  @credit_card_redirect
  Scenario: Credit Card account redirect
    When the user clicks on Credit card link on the Account Summary page
    Then the page title should be  "Zero - Account Activity"
    And Account drop down should have Credit Card selected

  Scenario: Loan account redirect
    When the user clicks on Loan link on the Account Summary page
    Then the page title should be  "Zero - Account Activity"
    And Account drop down should have Loan selected

