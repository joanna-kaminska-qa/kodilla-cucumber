package com.kodilla.divisiblenumberchecker;

public class DivisibleNumberChecker {

    public static String checkIfDivisible(int number) {
        String answer;
        if (number % 3 == 0 && number % 5 == 0) {
            answer = "FizzBuzz";
        } else if (number % 5 == 0) {
            answer = "Buzz";
        } else if (number % 3 == 0) {
            answer = "Fizz";
        } else {
            answer = "Number is not divisible netiher by 3 nor 5";
        } return answer;
    }
}