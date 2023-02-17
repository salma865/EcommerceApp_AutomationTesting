@Regression
Feature: Test Scenario 2

  Background: login pre requests
    Given browser opened to login

  Scenario: User log in with valid email and password
    When user enter valid email and password
    And user click login button
    Then user could login

  Scenario: User log in with invalid email and password
    When user enter invalid email and password
    And user click login button
    Then user couldn't login