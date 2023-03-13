@Regression
Feature: payment Functionality
  Background:
    Given User opens the application
  Scenario Outline: User can enter shipping information
    When User enters a "watch" into search box field
    And  User submits search
    And User chooses a product
    And User clicks on add to cart
    When User clicks on go to cart
    And User clicks on checkout button
    And User enters "<email>" , "<firstName>" , "<lastName>" , "<company>" , "<street>" , "<city>" , "<phone>" , "<zipCode>" fields
    And User chooses state and country
    And User chooses shipping method
    And User clicks on next button
    Then User is on payment page
    And User clicks on place order
    And User clicks on continue shopping
    Then User is on home page
    Examples:
      | email| firstName | lastName | company | street | city | phone | zipCode |
      |esraa@gmail.com|   esraa   |  Abdallah  |   workplace  | Al_Khattab|  Cairo    | 01234456578|12345|
