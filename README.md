# kodilla-cucumber

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Gradle](https://img.shields.io/badge/Gradle-8-green)
![Cucumber](https://img.shields.io/badge/Cucumber-7.12.0-brightgreen)
![JUnit](https://img.shields.io/badge/JUnit-5.9.1-purple)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Status: Completed](https://img.shields.io/badge/Status-Completed-brightgreen)

---

Behavior-Driven Development (BDD) with **Cucumber**, **Gherkin**, & **JUnit**

This repository contains exercises and homework implemented as part of a module in the **Kodilla "Automated Tester" Java course**, focusing on **Cucumber and Gherkin**.

The module focuses on **Behavior-Driven Development (BDD)** using:

- Cucumber 7.x
- Gherkin
- JUnit 5 (Jupiter + JUnit Platform Suite)
- Gradle

All examples were implemented in **IntelliJ IDEA**, using **Java 21**.

## Description

The module includes several independent BDD test groups, each demonstrating:

- Writing feature files
- Creating step definitions
- Configuring runners

The project was developed in **IntelliJ IDEA** as part of the learning path for future **QA/Test Automation Engineers**.


---

## Project Structure
```
kodilla-cucumber/
│ build.gradle
│ gradlew
│ gradlew.bat
│ LICENSE
│ settings.gradle
│ structure.txt
│
├── src/main/java/com/kodilla
│ ├── divisiblenumberchecker/
│ │ DivisibleNumberChecker.java
│ ├── seasonchecker/
│ │ SeasonChecker.java
│ └── wallet/
│ Cashier.java
│ CashSlot.java
│ InsufficientBalanceException.java
│ InvalidAmountException.java
│ Wallet.java
└── src/test/
├── java/
│ ├── divisiblenumberchecker/
│ │ IsNumberDivisibleSteps.java
│ │ TestRunner.java
│ ├── seasonchecker/
│ │ IsItSummerSteps.java
│ │ TestRunner.java
│ └── wallet/
│ TestRunner.java
│ WalletSteps.java
└── resources/
│ junit-platform.properties
├── divisiblenumberchecker/
│ is_number_divisible.feature
├── seasonchecker/
│ is_it_summer.feature
└── wallet/
negative_cash_withdrawal.feature
positive_cash_withdrawal.feature
wallet_balance.feature
```
---

## Build & Technology Stack

- **Java 17+**
- **Gradle**
- **Cucumber JVM 7.12.0**
- **JUnit 5**
- **JUnit Platform Suite Engine**
- **Gherkin feature files**

---

## Dependencies (Gradle)

```groovy
dependencies {
    testImplementation platform('org.junit:junit-bom:5.9.1')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    testImplementation 'org.junit.platform:junit-platform-suite:1.9.2'

    testImplementation 'io.cucumber:cucumber-java:7.12.0'
    testImplementation 'io.cucumber:cucumber-junit-platform-engine:7.12.0'
}
```

## Getting Started
**Run all tests**
```bash
./gradlew test
```
**Run only Cucumber scenarios**
```bash
./gradlew cucumber
```
**Run from IntelliJ**

Execute any of the TestRunner classes, e.g.:
```
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/")
public class TestRunner {}
```
---
## Test Suites Overview

This module contains **3 independent Cucumber-based test suites**:

### 1. Season Checker
**Purpose:** Determine if a given date falls within the summer months.

**Feature example (`is_it_summer.feature`):**

```gherkin
Scenario Outline: Checking if selected date is Summer
  Given today is <day> day of <month>
  When I ask whether it's Summer
  Then I should be told "<answer>"

Examples:
  | day | month     | answer        |
  | 31  | December  | Nope          |
  | 1   | August    | Yes! Summer!  |
Steps implemented in: IsItSummerSteps.java
```

### 2. Divisible Number Checker
A simple numerical checker verifying:
- Divisible by 3 → "Fizz"
- Divisible by 5 → "Buzz"
- Divisible by both → "FizzBuzz"
- Otherwise → "None"

Feature file: ```is_number_divisible.feature```

Step definitions: ```IsNumberDivisibleSteps.java```

### 3. Wallet Application (BDD Acceptance Tests)
Largest test group in the module. Implements real-life acceptance testing:

- Depositing money
- Withdrawing funds
- Checking wallet balance
- Handling insufficient funds
- Validating invalid amounts

Feature example:

```gherkin
Scenario: Successful withdrawal
  Given I have deposited $200 in my wallet
  When I request $30
  Then $30 should be dispensed
  And the balance of my wallet should be $170
```

Logic implemented through:
- Wallet.java — balance management
- Cashier.java — withdrawal handler
- CashSlot.java — simulates dispensing cash
- WalletSteps.java — Gherkin step bindings
---

## **Reports**

Cucumber reports: ```build/cucumber-reports/Cucumber.html```

JUnit-style test reports: ```build/reports/tests/test/index.html```

---
## What This Module Teaches
- Understanding Behavior-Driven Development (BDD)
- Writing readable acceptance tests with Gherkin
- Mapping feature steps to Java step definitions
- Running Cucumber tests using JUnit Platform
- Using Scenario Outlines and Examples
- Structuring multi-feature BDD projects
- Producing HTML reports for test documentation

---
## Authors

Created by:

**Joanna Kamińska**  
GitHub: https://github.com/joanna-kaminska-qa

---

## Version History

- **0.3** – README added, structure updated
- **0.2** – Added all Cucumber homework tasks (14.2, 14.3, 14.4)
- **0.1** – Initial exercises and examples

---

## License

This project is licensed under the **MIT License**.  
See the `LICENSE` file for details.

---

## Acknowledgments

- Kodilla Automated Tester – Java course
- Cucumber JVM Documentation
- Gherkin Language Reference
- JUnit Platform Documentation
- IntelliJ IDEA support for BDD workflows

