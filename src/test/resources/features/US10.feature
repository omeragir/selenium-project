@B29G1-301
Feature: Default

	
	@B29G1-289
	Scenario Outline: US270-TC01-Verify users write messages in the Description ** field on the calendar event page.
		  Given the user logged in as "<userType>"
		  Given user is on the dashboard page
		  When user hovers over the Activities module
		  And user  clicks on the Calendar Events button.
		  And user clicks on the Create Calendar Event button.
		  And user  enter "Scrum daily message" text  in the Description field
		  Then the event with the description should be created successfully

		Examples:
			| userType      |
			| driver        |
			| sales manager |
			| store manager |



