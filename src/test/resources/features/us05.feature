Feature: Vehicles Models Page web table functionality

  Agile story:  AC1: As a user, I want to view columns on the Vehicle models page. (web-table)
  Expected Column names:
  MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED), TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS
  AC2: Drivers should not able to access the Vehicle Model page, users should see “You do not have permission to perform this action.”


  @B29G1-310  @B29G1-281
  Scenario Outline: Column names for the store managers
    Given the user logged in as "<userType>"
    Given user is on the dashboard page
    And user hovers over "Fleet" tab and click "Vehicles Model" module
    Then user is navigated Vehicles Model page
    Then should see below a total of ten columns

      | MODEL NAME               |
      | MAKE                     |
      | CAN BE REQUESTED         |
      | CVVI                     |
      | CO2 FEE (/MONTH)         |
      | COST (DEPRECIATED)       |
      | TOTAL COST (DEPRECIATED) |
      | CO2 EMISSIONS            |
      | FUEL TYPE                |
      | VENDORS                  |


    Examples:
      | userType      |
      | sales manager |
      | store manager |


  @B29G1-311  @B29G1-283
  Scenario: An error message verification for drivers on the Vehicle Model page
    Given user is logged as a truck driver
    And user is on the dashboard page
    When driver hovers over "Fleet" module and click "Vehicles Model" menu
    Then user should see the error message "You do not have permission to perform this action."