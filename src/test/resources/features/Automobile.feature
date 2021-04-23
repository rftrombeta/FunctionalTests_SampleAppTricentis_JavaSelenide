Feature: Fill in Automobile Insurance forms to send quotation

  Scenario: Fill in Automobile Insurance Forms and send quotation
    Given that I'm in the Automobile Insurance form
    When I fill in all fields of the Vehicle Data form
    And I fill in all fields of the Insurant Data form
    And I fill in all fields of the Product Data form
    And I fill in all fields of the Price Option form
    And I fill in all fields of the Send Quote form
    And send quotation
    Then I should see the message Sending e-mail success