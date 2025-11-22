Feature: Cash Withdrawal - Positive Scenarios

Scenario Outline: Withdrawal from a wallet in credit
  Given I have deposited <money> into my wallet
  When I request <amount>
  Then <amount> should be dispensed
  And The balance of my wallet should be <balance>
  Examples:
  | money | amount | balance |
  | 200   | 30     | 170 |
  | 0     | 0      | 0   |
  | 200   | 0      | 200 |

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