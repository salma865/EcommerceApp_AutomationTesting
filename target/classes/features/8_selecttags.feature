@Regression
Feature: Test Scenario 8

  Background: select tags pre requests
    Given user open login page and login successfully
    And search for "Vintage Style Engagement Ring"
    And search results appear

  Scenario: Logged user could select (awesome) tag
    When user select "awesome" tag
    Then validate selecting "awesome" tag