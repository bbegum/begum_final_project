@regression @accounta
Feature: Accounts Feature

  Background:
    Given I am on Dark Sky Account Page


  @accounts-1

  Scenario Outline: Verify Invalid card information for multiple users
    When I enter <cardholdername> into cardholdername text fields on accounts screen
    And  I enter <cardnumber> into cardnumber text fields on accounts screen
    And  I enter <securitycode> into securitycode text fields on accounts screen
    And  I enter <address> into address text fields on accounts screen
    And  I enter <verifyaddress> into verifyaddress text fields on accounts screen
    And  I enter <city> into city text fields on accounts screen
    And  I enter <state> into state text fields on accounts screen
    And  I enter <zipcode> into zipcode text fields on accounts screen
    And  I enter <country> into country text fields on accounts screen
    And  I enter <month> into month text fields on accounts screen
    And  I enter <year> into year text fields on accounts screen
    And  I click on add card button
    Then I verify <errormessage> error message

    Examples:
      | cardholdername | cardnumber       | securitycode | year | month         | address         | verifyaddress   | city      | state | zipcode | country | errormessage       |
      | Bibi Begum     | 1234123412341234 | 123          | 2021 | February (02  | 123 harbor ave  | 123 harbor ave  | New Haven | ME    | 12345   | US      | invalidcard number |
      | Bibi Begum     | 4242424242424242 | 123          | 2021 | February (02) | 420 Herkimer st | 418 Herkimer st | Brooklyn  | NY    | 11213   | US      | carddeclined       |
      | Bibi Begum     | 4242424242424242 | 123          | 2019 | February (02) | 420 Herkimer st | 418 Herkimer st | Brooklyn  | NY    | 11213   | US      | invalidmonth       |
