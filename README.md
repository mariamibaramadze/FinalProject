# Group Members
Mariam Baramadze 

Nini Ruadze

Mariam Mirinashvili 

Nikoloz Khaindrava 

Guram mamadashvili

---

## Test Case Distribution

---

1)Mariam Baramadze:

UI: Test Case 1 –
Register User

Test Case 5 –
Register User with existing email

API:

API 11 – Create/Register User Account

API 7 – Verify Login with valid details

---

2)Nini Ruadze:

UI: Test Case 2 – Login User (correct credentials)

Test Case 3 – Login User (incorrect credentials)

API:

API 8 – Verify Login without email parameter

API 9 – DELETE To Verify Login

---
3)Mariam Mirinashvili:

UI: Test Case 4 – Logout User

Test Case 7 – Verify Test Cases Page

API:

API 6 – Search Product without parameter

API 5 – POST To Search Product

---
4)Guram Mamadashvili:

UI:
Test Case 6 – Contact Us Form

Test Case 8 – Verify All Products & Product Detail Page

API:

API 1 – Get All Products List

API 2 – POST To All Products List

---
5)Nikoloz Khaindrava:

UI:
Test Case 10 – Verify Subscription in Home Page

Test Case 11 – Verify Subscription in Cart Page

API:

API 3 – Get All Brands List

API 4 – PUT To All Brands List


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
