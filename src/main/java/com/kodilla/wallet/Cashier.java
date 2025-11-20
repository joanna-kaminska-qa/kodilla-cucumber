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
            throw new InsufficientBalanceException("Insufficient funds.");
        }
        cashSlot.dispense(amount);
    }
}
