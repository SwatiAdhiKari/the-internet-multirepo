@tag
Feature: Context Menu

  @tag1
  Scenario: Verify user can access context menu items
    Given User navigates to the-Internet url
	  When User clicks on Context Menu link
    Then User right clicks on the box
    Then User should see the alert and accepts it

