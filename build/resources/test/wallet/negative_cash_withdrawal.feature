Feature: Wallet Balance

Scenario Outline: User checks the balance of their wallet
  Given there is <money> in my wallet
  When I check the balance of my wallet
  Then I should see that the balance is <expectedMoney>
  Examples:
  | money | expectedMoney |
  | 200   | 200           |
  | 0     | 0             |