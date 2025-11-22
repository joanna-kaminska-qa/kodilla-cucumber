package com.kodilla.wallet;

public class Cashier {
    private final CashSlot cashSlot;

    public Cashier(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdraw(Wallet wallet, int amount) {
        if (amount < 0) {
            throw new InvalidAmountException("Amount cannot be negative.");
        }
        if (wallet.getBalance() < amount) {
            throw new InsufficientBalanceException("You do not have enough money in your wallet");
        }
        wallet.debit(amount);
        cashSlot.dispense(amount);
    }
}
