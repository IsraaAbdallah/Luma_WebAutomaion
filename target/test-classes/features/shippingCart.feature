@Regression
Feature: Shipping Cart Functionality
  Background:
    Given User opens the application

  Scenario: User can show total price and total count in shipping cart
    When User enters a "watch" into search box field
    And  User submits search
    And User chooses a product
    And User clicks on add to cart
    When User clicks on go to cart
    And Total price is displayed
    And Count of products is displayed

  Scenario: User can update product quantity
    When User enters a "watch" into search box field
    And  User submits search
    And User chooses a product
    And User clicks on add to cart
    When User clicks on go to cart
    When User chane product quantity and clicks update
    And Product quantity should be updated

  Scenario: User Can go to checkout page from shipping cart page
    When User enters a "watch" into search box field
    And  User submits search
    And User chooses a product
    And User clicks on add to cart
    When User clicks on go to cart
    When User clicks on checkout button
    And User is on checkout page
