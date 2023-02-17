@Regression
Feature: Test Scenario 11
  Background: add to compare list pre requests
    Given login succeeded
    And searching for "Science & Faith" succeeded

  Scenario: Logged user could add different products to compare list
    When user click add to compare list button
    Then item should be added to compare list