@regression @hotels.com
Feature: Hotels.com feature

  Background:
    Given I am on Hotels.com home page

  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default search result screen
    When I select property class <stars>
    Then I verify system displays only <stars> hotels on search result

    Examples:
      | stars    |
      | 5 stars |
      | 4 stars |
      | 3 stars |


