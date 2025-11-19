package divisiblenumberchecker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.kodilla.divisiblenumberchecker.DivisibleNumberChecker.checkIfDivisible;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsNumberDivisibleSteps {
private int number;
private String answer;

    @Given("the number is 1")
    public void the_number_is_1() {
        this.number = 1;
    }

    @Given("the number is 32")
    public void the_number_is_32() {
        this.number = 32;
    }
    @Given("the number is 82")
    public void the_number_is_82() {
        this.number = 82;
    }

    @Given("the number is 3")
    public void the_number_is_3() {
        this.number = 3;
    }

    @Given("the number is 93")
    public void the_number_is_93() {
        this.number = 93;
    }

    @Given("the number is 25")
    public void the_number_is_25() {
        this.number = 25;
    }

    @Given("the number is 500")
    public void the_number_is_500() {
        this.number = 500;
    }

    @Given("the number is 15")
    public void the_number_is_15() {
        this.number = 15;
    }

    @Given("the number is 135")
    public void the_number_is_135() {
        this.number = 135;
    }

    @When("I ask whether it's divisible by 3 or 5")
    public void i_ask_whether_it_s_divisible_by_3_or_5() {
        this.answer = checkIfDivisible(number);
    }

    @Then("I should receive answer {string}")
    public void i_should_receive_answer(String string) {
        assertEquals(string, this.answer);
    }
}