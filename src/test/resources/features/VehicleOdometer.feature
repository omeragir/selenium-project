@B29G1-300
Feature: As a user, I want to view car odometer info on the Vehicles Odometers page.

  AC1: Store and Sales managers should see the dedicated error message.
  AC2: Drivers should see the default page as 1.
  AC3: Divers should see the View Per Page is 25 by default.

  User types are: driver, sales manager, store manager


  @B29G1-297
  Scenario Outline: Store and Sales Managers should see Error
    Given the user is on the "login" page
    Given the user logged in as "<userType>"
    Given the user is on the dashboard page
    When the user hovers over the Fleet module and clicks Vehicles Odometer
    Then the user should see an error message "You do not have permission to perform this action."

    Examples:
      | userType      |
      | sales manager |
      | store manager |


  @B29G1-298
  Scenario Outline: Drivers should see the default page as 1
    Given the user is on the "login" page
    Given the user logged in as "<userType>"
    Given the user is on the dashboard page
    When the user goes to the Vehicles Odometer page
    Then the user should see the default page as 1

    Examples:
      | userType      |
      | driver        |


  @B29G1-299
  Scenario Outline: Drivers should see the View Per Page as 25 by default
    Given the user is on the "login" page
    Given the user logged in as "<userType>"
    Given the user is on the dashboard page
    When the user goes to the Vehicles Odometer page
    Then the user should see the View Per Page as 25 by default

    Examples:
      | userType      |
      | driver        |