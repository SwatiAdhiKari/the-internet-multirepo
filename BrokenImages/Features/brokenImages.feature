@tag
Feature: Broken Images

  @tag1
  Scenario: Verify user can see broken images
    Given User navigates to the-Internet url
	  When User clicks on Broken images link
    Then User should see broken images

