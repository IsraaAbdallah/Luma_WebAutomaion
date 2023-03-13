@Regression
Feature: productDetails Page functionality
  Background:
    Given User opens the application

  Scenario: User can add a product to shopping cart
    When User enters a "watch" into search box field
    And  User submits search
    And User chooses a product
    And User clicks on add to cart
    Then User can show successfully added to cart msg

  Scenario: User can add a product to compare list
    When User enters a "watch" into search box field
    And  User submits search
    And User chooses a product
    And User clicks on add to compare
    Then User can show successfully added to compare msg



  Scenario: Un logged User tries to add a product to wishList
    When User enters a "watch" into search box field
    And  User submits search
    And User chooses a product
    And User clicks on add to wishList
    Then User is redirected to login page
    And A message tells the user that he must login first  or sign up is appeared

  Scenario: User can add show productInfo
    When User enters a "watch" into search box field
    And  User submits search
    And User chooses a product
    And User clicks on product Info
    Then Product Information is displayed

  Scenario: User can add show productDetails
    When User enters a "watch" into search box field
    And  User submits search
    And User chooses a product
    And User clicks on productDetails
    Then Product description is displayed

  Scenario: User can navigate to reviews Box from productDetails page
    When User enters a "watch" into search box field
    And  User submits search
    And User chooses a product
    And User clicks on reviews
    Then Users' reviews are displayed

