@B29G1-309
Feature: Access to the Oronic Documentation page

  User story: As a user, I should be access to the Oroinc Documentation page. (Window handle)
  User types are: driver, sales manager, store manager

  @B29G1-296
  Scenario Outline: Accessing Oronic Documentation Page
    Given the user is on the "login" page
    Given the user logged in as "<userType>"
    Given user is on the dashboard page
    When user click the question icon
    And user switch to the new window
    And user on the Oronic Documentation page

    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |

