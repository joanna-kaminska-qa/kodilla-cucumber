package wallet;

import com.kodilla.wallet.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class WalletSteps {
    private final Wallet wallet = new Wallet();
    private final CashSlot cashSlot = new CashSlot();
    private Cashier cashier = new Cashier(cashSlot);
    private Exception exception;
    private int displayedBalance;

    @Given("I have deposited {int} into my wallet")
    public void i_have_deposited_into_my_wallet(int money) {
        exception = null;
        wallet.deposit(money);
    }

    @When("I request {int}")
    public void i_request_amount(int amount) {
        cashSlot.dispense(0);
        try {
            cashier.withdraw(wallet, amount);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @Then("{int} should be dispensed")
    public void amount_should_be_dispensed(int amount) {
        assertEquals(amount, cashSlot.getContents());
    }

    @Then("The balance of my wallet should be {int}")
    public void the_balance_of_my_wallet_should_be(int expectedBalance) {
        assertEquals(expectedBalance, wallet.getBalance());
    }

    @Then("an InvalidAmountException should be thrown")
    public void an_InvalidAmountException_should_be_thrown() {
        assertNotNull(exception);  //  upewniamy się, że wyjątek został przechwycony
        assertTrue(exception instanceof InvalidAmountException);  // sprawdzamy, czy to ten wyjątek co trzeba
    }

    @Then("an InsufficientBalanceException should be thrown")
    public void an_InsufficientBalanceException_should_be_thrown() {
        assertNotNull(exception);
        assertTrue(exception instanceof InsufficientBalanceException);
    }

    @Then("nothing should be dispensed")
    public void nothing_should_be_dispensed() {
        assertEquals(0, cashSlot.getContents());
    }

    @Then("I should be told that I don't have enough money in my wallet")
    public void I_should_be_told_that_I_don_t_have_enough_money_in_my_wallet() {
        assertEquals("You do not have enough money in your wallet", exception.getMessage());
    }

    @Given("there is {int} in my wallet")
    public void there_is_in_my_wallet(int money) {
        exception = null;
        wallet.deposit(money);
    }

    @When("I check the balance of my wallet")
    public void i_check_the_balance_of_my_wallet() {
        displayedBalance = wallet.getBalance();
    }

    @Then("I should see that the balance is {int}")
    public void i_should_see_that_the_balance_is(int expectedBalance) {
        assertEquals(expectedBalance, displayedBalance);
    }
}