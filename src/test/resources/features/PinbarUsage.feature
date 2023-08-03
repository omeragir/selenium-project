@B29G1-304
Feature: Learn how to use the Pinbar
  User Story:
  As a user, I want to learn how to use the Pinbar
  So that I create fast access links for my favorite pages
  User types are: driver, sales manager, store manager

  @B29G1-277
  Scenario Outline: Verify that users click the "Learn how to use this space" link
    Given the user is on the "login" page
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


  @B29G1-295
  Scenario Outline: Verify user sees an image on the page
    Given the user is on the "login" page
    Given the user logged in as "<userType>"
    Given user is on the dashboard page
    When user clicks Learn how to use this space link
    Then user should see an image on the page.


    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |
