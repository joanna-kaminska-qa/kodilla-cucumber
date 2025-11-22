Feature: Cash Withdrawal

Scenario Outline: Withdrawal from a wallet in credit

  Given I have deposited <money> into my wallet
  When I request <amount>
  Then <amount> should be dispensed
  And The balance of my wallet should be <balance>
  Examples:
  | money | amount | balance |
  | 200   | 30     | 170 |
  | 0   | 0     | 0 |
  | 200   | 0     | 200 |

  Scenario: Withdrawal of negative amount
    Given I have deposited 200 into my wallet
    When I request -30
    Then an InvalidAmountException should be thrown

  Scenario: Withdrawal of amount greater than balance
    Given I have deposited 200 into my wallet
    When I request 300
    Then an InsufficientBalanceException should be thrown
    And nothing should be dispensed
    And I should be told that I don't have enough money in my wallet

  Scenario Outline: User checks the balance of their wallet
    Given there is <money> in my wallet
    When I check the balance of my wallet
    Then I should see that the balance is <expectedMoney>
    Examples:
    | money | expectedMoney |
    | 200   | 200     |
    | 0   | 0     |

  Scenario: User withdraws money multiple times
    Given I have deposited 200 into my wallet
    When I request 50
    Then 50 should be dispensed
    And The balance of my wallet should be 150
    When I request 100
    Then 100 should be dispensed
    And The balance of my wallet should be 50
    When I request 70
    Then an InsufficientBalanceException should be thrown
    And nothing should be dispensed
    And I should be told that I don't have enough money in my wallet