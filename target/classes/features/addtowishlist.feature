@Regression
Feature: Test Scenario 10

  Background: add to wishlist pre requests
    Given user is logged in
    And searching for item "Ray Ban Aviator Sunglasses" done

  Scenario: Logged user could add different products to Wishlist
    When user click add to wishlist button
    Then item should be added to wishlist