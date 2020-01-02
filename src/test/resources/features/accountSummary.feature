@account_summary

Feature: Account Summary

  Background: When the user is able to login

  @account_summary_page_title
  Scenario: User should see Account Summary page title
    Then the user should see page title as "Zero - Account Summary"

  @account_types
  Scenario: User should see all account types
    Then the user should be able to see the following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  @credit_account_columns
  Scenario: User should see Credit Account columns
    Then the user should be able to see the following Credit Account columns
      | Account     |
      | Credit Card |
      | Balance     |
