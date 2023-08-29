Feature: Test Tradme searching feature

  Background: Navigate to Tradme site
    Given I navigate to https://www.trademe.co.nz/a/

 @Smoke
  Scenario Outline: As a user, I want find a product
    When I search the product <product>
    Then I can see a result text with <productExpected>
    Examples:
      | product     | productExpected |
      | playstation | playstationj    |


  Scenario: As a user, I want find an specific product
    When I search the product dog
    Then I can see a result text with playstation