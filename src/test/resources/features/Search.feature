@Regression
Feature: Search functionality
  Background:
    Given User opens the application

  Scenario Outline: User searches for a valid product
    When  User enters a "<productName>" into search box field
    And  User submits search
    Then User should get valid product displayed in search results
    And Related search terms list is displayed
    Examples:
      |productName  |
      |Digital watch|
      |Bags         |


  Scenario: User searches for an invalid product
    When  User enters a "necklace" into search box field
    And  User submits search
    Then User should get a warning message about returning no results

  Scenario: User searches for a valid product through autocomplete list
    When  User enters a "Digital watch" into search box field
    Then  Relevant keywords are suggested in the autocomplete search list
    When User clicks on an item in the list
    Then User should get valid product displayed in search results


  Scenario: User searches for a valid product and selects the products by a sorter
    When   User enters a "jacket" into search box field
    And  User submits search
    Then User should get valid product displayed in search results
    When User selects a sorter from a sorter list
    Then Products should be ordered by the selected sorter
    When User clicks on sort direction arrow
    Then Sort Direction should be changed

