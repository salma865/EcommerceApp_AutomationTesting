@Regression
Feature: Test Scenario 9

  Background: add to cart pre requests
    Given login done
    And searching for "Portable Sound Speakers"

  Scenario: Logged user could add different products to Shopping cart
    When user click add to cart button
    Then item should be added to cart