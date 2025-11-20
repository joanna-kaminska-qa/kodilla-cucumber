Feature: Cash Withdrawal

Scenario Outline: Withdrawal from a wallet in credit

  Given I have deposited <money> into my wallet
  When I request <amount>
  Then <amount> should be dispensed
  Examples:
  | money | amount |
  | 200   | 30     |
  | 0   | 0     |
  | 200   | 0     |

  Scenario: Withdrawal of negative amount
    Given I have deposited 200 into my wallet
    When I request -30
    Then an InvalidAmountException should be thrown

  Scenario: Withdrawal of amount greater than balance
    Given I have deposited 200 into my wallet
    When I request 300
    Then an InsufficientBalanceException should be thrown