@smoke
Feature: Login

  Background:the user is on the login page

  @successful_login
  Scenario: User should successfully login
    When the user enters valid login credentials
    Then the user should be able to login

    @unsuccessful_login
  Scenario: Users with wrong username or wrong password should not be able to login
    When the user enters invalid login credentials
    Then the system should display "Login and/or password are wrong."

  @unsuccessful_login
  Scenario: Users should not be able to login with blank input
    When the user enters blank login credentials
    Then the system should display "Login and/or password are wrong."




