@Regression
Feature: Test Scenario 12

  Background: create order pre requests
    Given user login to create order
    And search for "Windows 8 Pro" product successfully
    And user add product to shopping cart successfully and open cart

  Scenario: Create successful Order
    When user agree with terms
    And user click checkout
    And user fill Billing address data
    And user chose Shipping method
    And user chose Payment method
    And user read Payment information and continue
    And user confirm order
    Then order created successfully