@tag
Feature: Exit Intent

  @tag1
  Scenario: Verify user can see pop up when mouse moved out of viewport pane
    Given User navigates to the-Internet url
	  When User clicks on Exit Intent link
    Then User moves mouse out of viewport pane
    Then User should see the pop up and closes it

