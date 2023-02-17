@Regression
Feature: Test Scenario 6

  Background: select categories pre requests
    Given login done successfully

  Scenario: Logged user could select different Categories
    When user select category
    Then selected category page is opened