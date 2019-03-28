@regression @DarkSky
Feature: Dark Sky Test


  Background:
    Given I am on Dark Sky Home Page

  @DarkSkyTest1
  Scenario:Verify timeline is displayed in correct format
    And I verify the first index is Now
    Then I verify timeline is displayed with 2 hours incremented

  @DarkSkyTest2
  Scenario: Verify individual day temp timeline
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly


  @DarkSkyTest3
  Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
    Then I verify current temp is not greater or less then temps from daily timeline


  @DarkSkyTest
  Scenario: Verify click
    And I scroll to Time Machine Button
    And I click on Time Machine Button
    And I click on Today's Date
    Then I verify Weather Date

  @DarkSkyTest5
  Scenario: click API button
    When I click on API button
    And I click On login button
    And I enter the login information
    Then I click on Account Settings
    And I scroll down to card information section


