# Group Members
Mariam Baramadze 

Nini Ruadze

Mariam Mirinashvili 

Nikoloz Khaindrava 

Guram mamadashvili

---

## Test Case Distribution
-Mariam Baramadze
-Nini Ruadze
-Mariam Mirinashvili
-Nikoloz Khaindrava
-Guram mamadashvili

---

## Instructions for Running the Tests
### Prerequisites
* Java 8 or higher installed
* Maven installed
* Chrome browser installed
* IntelliJ IDEA (recommended)

---

### Running Tests from IntelliJ
1. Open the project in IntelliJ IDEA
2. Wait for Maven dependencies to load
3. Open [ testNG.xml ]
4. Right-click -> Run
All UI and API tests will execute.

---

### Running Tests using Maven (Terminal)

Open terminal inside project folder and run:

```
mvn clean test
```
This will execute all tests defined in the project.

---

## Generating Allure Report

After running the tests, generate the Allure report using:

```
allure serve allure-results
```

This command will:

* Generate the report
* Open it in your browser

If Allure is not installed, download it from:
https://docs.qameta.io/allure/

---

## Project Structure

* UI Tests – Selenium WebDriver
* API Tests – RestAssured
* Test Runner – TestNG
* Reports – Allure
