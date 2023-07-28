@B29G1-288
Feature:User should able to select a/the car
  User Story:
  As a user, I should be able to select any vehicle from the Vehicle page
  User types are: sales manager, store manager


  @B29G1-290
  Scenario Outline: All the checkboxes should be unchecked by default.
    Given the user is on the "login" page
    Given the user logged in as "<userType>"
    Given user is on the dashboard page
    When  user hovers over Fleet module and clicks Vehicles menu
    Then  all the checkboxes should be unchecked by default
    Examples:
      | userType      |
      | sales manager |
      | store manager |


  @B29G1-291
  Scenario Outline: User checks the first checkbox to check all the cars
    Given the user is on the "login" page
    Given the user logged in as "<userType>"
    Given user is on the dashboard page
    When  user hovers over Fleet module and clicks Vehicles menu
    And   user checks the first checkbox
    Then  all cars should be checked.
    Examples:
      | userType      |
      | sales manager |
      | store manager |


  @B29G1-292
  Scenario Outline:  Users can select any car
    Given the user is on the "login" page
    Given the user logged in as "<userType>"
    Given user is on the dashboard page
    When  user hovers over Fleet module and clicks Vehicles menu
    And   user checks one of the cars randomly
    Then  a random car should be checked
    Examples:
      | userType      |
      | sales manager |
      | store manager |