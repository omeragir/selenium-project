
Feature:Users see error messages

  User Story:
  As a user, I should see error messages when I enter an
  invalid integer into the calendar repeat day input box.
  User types are: driver, sales manager, store manager


  Scenario Outline: Verify error message
    Given the user logged in as "<userType>"
    When  user hovers over Activities module and clicks Calendar Events menu
    Then  user is on the Calendar Events page and clicks Create Calendar Event button.
    And   user click Repeat checkbox icon
    And   user enters less than one in Repeat Every part
    Then  user see "The value have not to be less than 1." error message

    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |


  Scenario Outline: Verify error message
    Given the user logged in as "<userType>"
    When  user hovers over Activities module and clicks Calendar Events menu
    Then  user is on the Calendar Events page and clicks Create Calendar Event button.
    And   user click Repeat checkbox icon
    And   user enters more than ninety nine in Repeat Every part
    Then  user see "The value have not to be more than 99." new error message
    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |