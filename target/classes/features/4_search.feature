@Regression
Feature: Test Scenario 4

  Scenario: Logged User could search for any product
    Given browser opened and user navigate to login page
    And user enter his email and password and login successfully
    When user search for "Apple iCam"
    Then search completed successfully