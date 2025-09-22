📺 STC Subscription Automation Task:

  📌 Overview

      This project automates the validation of subscription packages (Type, Price, and Currency) across different countries (Saudi Arabia, Kuwait, and Bahrain) for the STC TV Subscription Website.


The framework is built with:

    1-Java

    2-Selenium 4

    3-TestNG

    4-Page Object Model (POM)

    5-Data-Driven Testing (JSON input)

    6-Maven (for build & dependency management)

    7-Extent Reports



🧪 Test Scenarios

    The automated tests perform the following validations:

      Navigate to STC TV Subscription Page.

      Switch country (Saudi Arabia, Kuwait, Bahrain).

  Validate subscription packages for each country:

      Package Type (Basic, Premium)

      Price

      Currency



✅ Best Practices Applied

    1-Selenium 4 with WebDriverManager (automatic driver setup).

    2-Page Object Model (POM) for maintainability.

    3-Data-Driven Tests with JSON (easy extension to new countries).

    4-Assertions for package type, price, and currency.

    5-TestNG Annotations (@BeforeTest, @AfterTest, @DataProvider).



📌 Requirements:

    1-Java 17+

    2-Maven 3.8+

    3-Internet connection (tests run on live website)
