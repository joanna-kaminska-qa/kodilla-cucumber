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

    @Given("I have deposited {int} into my wallet")
    public void i_have_deposited_into_my_wallet(int money) {
        wallet.deposit(money);
    }

    @When("I request {int}")
    public void i_request_amount(int amount) {
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
}