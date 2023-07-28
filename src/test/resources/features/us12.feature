@accountsPage
Feature: As a user, I want to filter customers’ info on the Account page

  Scenario Outline: Users should see 8 filter items on the Accounts page
    Given the user is on the "login" page
    Given the user logged in as "<userType>"
    Given user is on the dashboard page
    When User hovers mouse over "Customers" tab and click "Accounts" module
    And User go to the "All - Accounts - Customers"
    Then User should be able to see  below eight filter items on the Accounts page

      | Account Name  |
      | Contact Name  |
      | Contact Email |
      | Contact Phone |
      | Owner         |
      | Business Unit |
      | Created At    |
      | Updated At    |


    Examples:
      | userType      |
      | sales manager |
      | store manager |