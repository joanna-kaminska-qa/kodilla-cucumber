Feature:  Is number divisible by 3 or 5?

Scenario Outline: Number is or is not divisible by 3 or 5

      Given the number is <number>
      When  I ask whether it's divisible by 3 or 5
      Then  I should receive answer <answer>
      Examples:
| number | answer |
| 1 | "Number is not divisible netiher by 3 nor 5" |
| 32 | "Number is not divisible netiher by 3 nor 5" |
| 82 | "Number is not divisible netiher by 3 nor 5" |
| 3 | "Fizz" |
| 93 | "Fizz" |
| 25 | "Buzz" |
| 500 | "Buzz" |
| 15 | "FizzBuzz" |
| 135 | "FizzBuzz" |