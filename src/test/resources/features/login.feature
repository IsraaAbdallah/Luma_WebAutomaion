@Sanity
Feature: Login functionality
  Background:
    Given User is on login page

  Scenario: User should be able to login with valid credentials
    When User fills email field as "esraa@gmail.com" and password field as "Abcd1234" and hits submit button
    Then User should be logged in successfully

  Scenario Outline: Unsuccessful Login with invalid credentials
      When User fills email field as "<userName>" and password field as "<password>" and hits submit button
      Then Error message should appear
    Examples:
    |   userName              |   password       |
    |   randa@gmail.com       |   mnk123         |

  Scenario: Unsuccessful Login with blank credentials
    Given User is on login page
    When User fills email field as "" and password field as "" and hits submit button
    Then missing email message and missing password messages should appear

