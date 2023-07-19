@wip-US03
Feature: Pin bar functionality
  User Story:
  As a user, I want to learn how to use the pin bar
  User types are: driver, sales manager, store manager


  Scenario Outline: Verify that users click the "Learn how to use this space" link
    Given the user logged in as "<userType>"
    Given user is on the dashboard page
    When user clicks Learn how to use this space link
    Then user should see "How To Use Pinbar"
    Then user sees "Use pin icon on the right top corner of page to create fast access link in the pinbar."

    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |



  Scenario Outline:
    Given the user logged in as "<userType>"
    Given user is on the dashboard page
    When user clicks Learn how to use this space link
    Then user should see an image on the page.


    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |
