# Almosafer Website Automation Test Suite

This document describes a Selenium-based TestNG automation test suite written in Java for testing various functionalities of the [Almosafer website](https://www.almosafer.com). The project consists of two classes:

- `Almosafer.java`: Contains the test cases.
- `TestDataAndFunctions.java`: Contains reusable methods and test data.

---

## 🔧 Setup and Dependencies

- **Browser**: Google Chrome
- **Framework**: TestNG
- **Automation Tool**: Selenium WebDriver
- **Language**: Java

---

## 📁 Project Structure

### 1. `TestDataAndFunctions.java`

This class handles:
- Browser setup and navigation.
- Predefined expected values (currency, language, dates).
- Helper methods:
  - `EnterTheWebsite()`: Opens the website, maximizes the window, and accepts cookies.
  - `CheckTheLanguageAndSendRandomCityName()`: Detects site language and enters a random city accordingly.
  - `RandomlySelectNumberOfVisitors()`: Randomly selects a number of visitors and performs a search.

---

### 2. `Almosafer.java`

This class inherits from `TestDataAndFunctions` and contains all the test cases.

#### ✅ Test Cases Overview

| Priority | Test Name                                         | Description |
|----------|---------------------------------------------------|-------------|
| 1        | `CheckTheLanguage()`                              | Validates the current language (`en`) using `<html lang>`. |
| 2        | `CheckTheCurrency()`                              | Checks that the displayed currency is `SAR`. |
| 3        | `CheckTheContactNumber()`                         | Validates that the phone number shown is `+966554400000`. |
| 4        | `CheckqitafLogo()`                                | Verifies Qitaf logo is displayed in the footer. |
| 5        | `CheckHotelTabIsNotSelectedByDefault()`           | Ensures the hotel tab is **not** selected on initial load. |
| 6        | `CheckDepatureDate()`                             | Confirms that the departure date equals tomorrow's date. |
| 7        | `CheckReturnDate()`                               | Confirms the return date is the day after tomorrow. |
| 8        | `RandomlyChangeTheLanguage_And_Random_Ar_Or_En_Cities()` | Navigates to a random language version, selects hotel tab, enters a random city (based on language), selects visitors, and submits search. |
| 9        | `CheckThatTheNewSearchPageIsFullyLoaded()`        | Validates that the results page is fully loaded by checking for specific elements (`مكان` or `found`). |

---

## 🔄 Test Data Summary

- **Languages Supported**: `en`, `ar`
- **Expected Values**:
  - Language: `en`
  - Currency: `SAR`
  - Phone: `+966554400000`
  - Qitaf Logo: Displayed
- **Cities**:
  - English: `jeddah`, `riyadh`, `dubai`
  - Arabic: `دبي`, `جدة`
- **Departure Date**: Tomorrow
- **Return Date**: Day after tomorrow

---

## 🧠 Highlights

- Test design follows **priority-based execution** using TestNG.
- Uses dynamic data generation (`Random`) for selecting cities and visitor counts.
- Verifies both UI behavior and DOM attributes.
- Leverages JavaScript execution and scrolls to the footer for hidden elements.

---

## 📝 Improvements & Recommendations

- Consider using Page Object Model (POM) for better code modularity.
- Externalize test data into `.properties` or `.json` files.
- Add validations for search result accuracy (hotel names, filters).
- Implement logging and test reports (e.g., Allure, ExtentReports).

---

## 🚀 How to Run

1. Ensure ChromeDriver is set up and in your system path.
2. Use TestNG runner or your IDE (e.g., IntelliJ, Eclipse).
3. Run `Almosafer.java` as a TestNG suite.

---

© 2025 - Almosafer Automation Suite
