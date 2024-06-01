
Feature: Checking the-Internet Functionalities

  @test
  Scenario: Validate user is able to add Element
  Given User navigates to the-Internet url
  When User clicks on Add/Remove Elements link
  Then User should be able to add element.
  
   @test
  Scenario: Validate user is able to remove Element
  Given User navigates to the-Internet url
  When User clicks on Add/Remove Elements link
  Then User should be able to remove the added element.
  
    

