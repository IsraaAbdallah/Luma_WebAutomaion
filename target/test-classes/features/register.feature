@Smoke
Feature: Registration functionality
  Background:
    Given User navigates to Create an Account page

 Scenario: User registers only by filling all mandatory fields
    When User fills the "Noran" and "Nabeeh" and "noran@gmail.com" and "#123asdf" and "#123asdf" and clicks on Create an Account button
    Then User account should be created successfully
    And Welcome user message is displayed

 Scenario Outline: User creates a duplicate account
    When User fills the "<firstName>" and "<lastName>" and "<email>" and "<password>" and "<confirmPassword>" and clicks on Create an Account button
    And A warning about a duplicate account using a duplicate email should be appeared
    And A link to reset forget password page is displayed
    And User clicks on reset password link
    Then User is on forget password page
    Examples:
      |   firstName  |   lastName       |   email              |   password       |confirmPassword|
      |   noha       |   rashed         |yara@gmail.com         |#1234asdf         |#1234asdf      |



  Scenario: Unsuccessful registration using blank fields
    Given User navigates to Create an Account page
    When User fills the "" and "" and "" and "" and "" and clicks on Create an Account button
       Then A warning of missing field is displayed for each mandatory field

