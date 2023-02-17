@Regression
Feature: Test Scenario 5
  Background: pre requests (login and search for any product)
    Given browser opened and user login successfully
    And user search for "Apple iCam" and search completed successfully

  Scenario: Logged User could switch between currencies (US->Euro)
    When user switch to Euro
    Then currency is Euro

  Scenario: Logged User could switch between currencies (Euro->US)
    When user switch to US
    Then currency is US
