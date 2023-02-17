@Regression
Feature: Test Scenario 7

  Background: filter with color pre Requests
    Given user login
    And user select category Apparel > Shoes

  Scenario: Logged user could filter with color
    When user filter with color red
    Then only red elements should appear