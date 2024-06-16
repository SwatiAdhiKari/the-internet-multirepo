
@tag
Feature: Basic Auth

	  
	@tag1
  Scenario: Verify that user is unable to land to Basic Auth page with incorrect credentials
    Given User navigates to the-Internet url
	  When User clicks on Basic Auth link
	  And User enters the incorrect password in the alert pop-up
	  Then User should see Authentication alert again
    

  @tag1
  Scenario: Verify that user is able to land to Basic Auth page with correct credentials
    Given User navigates to the-Internet url
	  When User clicks on Basic Auth link
	  And User enters the credentials in the alert pop-up
	  Then User should be able to navigate to Basic Auth page.
	
