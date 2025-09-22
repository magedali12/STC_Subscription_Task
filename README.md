📺 STC Subscription Automation Task
📌 Overview

This project automates the validation of subscription packages (Type, Price, and Currency) across different countries (Saudi Arabia, Kuwait, and Bahrain) for the STC TV Subscription Website
.

The framework is built with:

Java

Selenium 4

TestNG

Page Object Model (POM)

Data-Driven Testing (JSON input)

Maven (for build & dependency management)


🧪 Test Scenarios

The automated tests perform the following validations:

Navigate to STC TV Subscription Page
.

Switch country (Saudi Arabia, Kuwait, Bahrain).

Validate subscription packages for each country:

Package Type (Lite, Classic, Premium)

Price

Currency



✅ Best Practices Applied

Selenium 4 with WebDriverManager (automatic driver setup).

Page Object Model (POM) for maintainability.

Data-Driven Tests with JSON (easy extension to new countries).

Assertions for package type, price, and currency.

TestNG Annotations (@BeforeTest, @AfterTest, @DataProvider).



📌 Requirements

Java 17+

Maven 3.8+

Internet connection (tests run on live website)
