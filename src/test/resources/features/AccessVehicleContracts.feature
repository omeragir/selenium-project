@B29G1-264
Feature:User should be able to access Vehicle Contracts Page
  User Story:
  As a user, I want to access to Vehicle contracts page
  User types are: sales manager, store manager

  @B29G1-293
  Scenario Outline: Verify that user can access Vehicle contracts page
    Given the user is on the "login" page
    Given the user logged in as "<userType>"
    Given user is on the dashboard page
    When  user hovers over "Fleet" module and clicks on the "Vehicle Contracts" menu
    Then  user should be able to access the page successfully.
    Then  title should be "All - Vehicle Contract - Entities - System - Car - Entities - System".

    Examples:
      | userType      |
      | sales manager |
      | store manager |


  @B29G1-294
  Scenario: Verify that user attempts to access Vehicle contracts page
    Given the user is on the "login" page
    Given the user logged in with username as "User1" and password as "UserUser123"
    And user should click error messages
    When  user hovers over "Fleet" module and clicks on the "Vehicle Contracts" menu
    Then user should see an error message saying "You do not have permission to perform this action."



