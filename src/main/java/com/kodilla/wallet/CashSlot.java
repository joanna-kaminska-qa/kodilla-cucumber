package com.kodilla.wallet;

public class CashSlot {
    private int contents;

    public int getContents() {
        return contents;
    }

    public int dispense(int amount) {
        return this.contents = amount;
    }
}