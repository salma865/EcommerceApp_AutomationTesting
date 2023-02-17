@SmokeTesting
Feature: Test Scenario 1

  Scenario: User could register with valid data
    Given browser opened to register
    And website opened to register
    And user navigate to registration page
    When user enter valid data
    And user click on register button
    Then user are registered successfully