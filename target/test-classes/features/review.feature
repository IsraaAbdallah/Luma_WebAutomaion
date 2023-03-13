@Regression
Feature: Review functionality
  Background:
    Given User opens the application

  Scenario Outline: User can add review
    When User enters a "jacket" into search box field
    And  User submits search
    And User chooses a product
    And User clicks on add review
    And User sets review rate
    And User the "<neckName>" and "<summary>" and "<review>" fields and clicks on submit review
    Then Review added successfully message is appeared
    Examples:
      | neckName | summary | review |
    |    Esraa|  The product is not as expected| I wish to consider my review|



 