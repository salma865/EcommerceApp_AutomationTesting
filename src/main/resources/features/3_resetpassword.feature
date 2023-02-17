@Regression
Feature: Test Scenario 3

  Scenario: User could reset his/her password successfully
    Given browser opened
    And website opened
    And user navigate to login page
    When user click on forgot password and reset password page is opened
    And user enter his email
    And user click on recover button
    Then reset mail is send to the user

