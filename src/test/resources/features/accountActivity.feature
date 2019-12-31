@account_activity
Feature: Account Activity

  Background:
    Given the user is able to login
    When the user clicks on Account Activity tab

  @account_activity_page_title
  Scenario: Verify Account Activity pageTitle

    Then the page title should be  "Zero - Account Activity"

  @savings_account_default
  Scenario: Savings account redirect
    Then the system should display default account type as "Savings"

  @account_types
  Scenario: Verify account types
    Then the system should have the following account types available
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

    @transactions_table
    Scenario: Verify transaction table headers
      Then the system should display the following headers on transactions table
    |Date|
    |Description|
    |Deposit    |
    |Withdrawal|




