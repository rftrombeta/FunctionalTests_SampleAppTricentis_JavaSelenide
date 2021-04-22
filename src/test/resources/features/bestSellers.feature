Feature: Buy all best sellers in My Store

  Scenario: Select all best sellers items and make payment
    Given I add all best sellers items into cart
    When I register myself at My Store website
    And I try to make the payment
    Then should successful perform the order