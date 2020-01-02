@pay_bills
Feature: Pay Bills

  Background:
    Given the user is able to login
    When the user clicks on Pay Bills tab

  @pay_bills_page_title
  Scenario: Verify Pay Bills pageTitle

    Then the page title should be  "Zero - Pay Bills"

  @pay_bills_positive_scenario
  Scenario: Verify successful payment message
    When the user completes a successful Pay operation
    Then "The payment was successfully submitted." message should be displayed

  @pay_bills_missing_data_or_amount
    Scenario: Verify missing field message
    When the user fails to enter valid amount
    And the user fails to enter valid date
    Then "Please fill out this field message!" should be displayed

