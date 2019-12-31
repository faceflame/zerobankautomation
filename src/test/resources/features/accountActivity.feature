@account_activity

Feature: Account Activity


  @account_activity_page_title
  Scenario: User should see Account Activity page title
    When the user is able to login
    Then the page title should be  "Zero - Account Activity"
