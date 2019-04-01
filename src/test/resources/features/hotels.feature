@regression @hotels.com
Feature: Hotels.com feature

  Background:
    Given I am on Hotels.com home page

  @Hotels-test1
  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default search result screen
    When I select property class <stars>
    Then I verify system displays only <stars> hotels on search result

    Examples:
      | stars   |
      | 5 stars |
      | 4 stars |
      | 3 stars |

  @Hotels-test-2
  Scenario: List of all of hotel within 10 miles radius of airport or downtown
    Given I am on default search result screen
    Then I verify system displays all hotels within 10 miles radius of airport
    And I verify hilton Hotel is within radius


