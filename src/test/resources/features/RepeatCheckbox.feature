@B29G1-287
Feature: Repeat checkbox verification
  User Story:As a user, I want to create a recurring(repetitive) calendar event.


  @B29G1-284
  Scenario Outline: US268-TC01-Verify users  see the number“1” by default in the Repeat Every input
    Given the user is on the "login" page
    Given the user logged in as "<userType>"
    Given user is on the dashboard page
    When  user clicks on the "Activities" tab and then selects "Calendar Events" module
    Then user is on the "Calendar Events" page
    And user clicks on the Create Calendar Event button
    Then user is on the Create Calendar event page
    And user clicks on the Repeat checkbox
    Then user sees the number "1" selected by default
    When user deletes "1"
    Then user sees the error message "This value should not be blank."

    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |

