Feature: User Login
  In order to access my account
  As a registered user
  I want to log in to the application

  Background:
    Given the application is running

  @mytag
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    And clicks the login button
    Then the user should be redirected to the dashboard with tittle "Secure Page page for Automation Testing Practice"
    And see a welcome message "You logged into a secure area!"

  @mytag
  Scenario: Failed login with invalid password
    Given the user is on the login page
    When the user enters a valid username and an invalid password
    And clicks the login button
    Then the user should see an error message "Your password is invalid!"

