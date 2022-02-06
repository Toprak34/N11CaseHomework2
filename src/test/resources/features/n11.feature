Feature: N11 Test Automation

  Scenario: Choosing products and making wrong payments
    Given User go to home page and search "ayfone"
    When user adds product to basket
    Then user pays with wrong credit card number