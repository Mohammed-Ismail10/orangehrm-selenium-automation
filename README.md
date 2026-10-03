# OrangeHRM Test Automation Framework

A test automation framework built with **Java, Selenium WebDriver, TestNG, Maven, and REST Assured** for testing the OrangeHRM web application.

The project demonstrates practical implementation of UI automation, API testing, Page Object Model, TestNG features, cross-browser testing, parallel execution, and test reporting.

---

## 🛠️ Technologies & Tools

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* WebDriverManager
* REST Assured
* Extent Reports
* Allure Reports
* IntelliJ IDEA
* Git & GitHub

---

## 📋 Application Under Test

**OrangeHRM**

Application URL:

https://opensource-demo.orangehrmlive.com/

---

## 📁 Project Structure

```text
orangehrm-selenium
│
├── pom.xml
├── testng.xml
├── testing-regression.xml
│
├── src
│   ├── main
│   │   └── java
│   │       └── org.example
│   │           ├── api
│   │           │   └── EmployeeApi.java
│   │           │
│   │           ├── constants
│   │           │   └── Constants.java
│   │           │
│   │           ├── pages
│   │           │   ├── LoginPage.java
│   │           │   ├── DashboardPage.java
│   │           │   └── EmployeePage.java
│   │           │
│   │           └── utils
│   │               ├── ReportManager.java
│   │               └── ScreenshotUtils.java
│   │
│   └── test
│       └── java
│           └── org.example
│               ├── base
│               │   ├── BaseTest.java
│               │   └── ApiBaseTest.java
│               │
│               ├── listeners
│               │   └── TestListener.java
│               │
│               └── tests
│                   ├── LoginTest.java
│                   ├── DashboardTest.java
│                   ├── EmployeeTest.java
│                   ├── DependencyTest.java
│                   └── EmployeeApiTest.java
```

---

## 🧪 Test Coverage

### UI Testing

The framework currently covers:

* Login with valid credentials
* Login with invalid credentials
* Login with multiple test data sets
* Dashboard verification
* Time at Work section verification
* Add Employee
* Add Employee with multiple test data sets
* Employee page verification
* Test dependencies

### API Testing

The project also includes API tests using **REST Assured**:

* Get employee by employee number
* Get employees
* HTTP status code validation
* Response data validation

---

## 🧩 TestNG Features

The project demonstrates the following TestNG concepts:

1. **Annotations**
2. **Assertions**
3. **Groups**
4. **Parameters**
5. **DataProvider**
6. **Dependencies**
7. **TestNG XML**
8. **Listeners**

### TestNG Groups

Tests are organized into groups such as:

```text
smoke
regression
login
dashboard
employee
```

This allows specific categories of tests to be executed through TestNG XML configuration.

---

## 🌐 Cross-Browser Testing

The framework supports multiple browsers:

* Google Chrome
* Mozilla Firefox
* Microsoft Edge

The browser can be selected through TestNG parameters:

```xml
<parameter name="browser" value="chrome"/>
```

---

## ⚡ Parallel Execution

The framework supports parallel execution across different browsers using TestNG.

Example:

```xml
<suite
    name="OrangeHRM Suite"
    parallel="tests"
    thread-count="3">
```

This allows Chrome, Firefox, and Edge tests to execute in parallel.

---

## 🏗️ Page Object Model

The project follows the **Page Object Model (POM)** design pattern.

Page classes contain:

* Web element locators
* Page actions
* Explicit waits
* Reusable methods

Examples:

```text
LoginPage
DashboardPage
EmployeePage
```

Test classes are responsible for:

* Test scenarios
* Test data
* Assertions
* TestNG configuration

This separation makes the framework easier to maintain and reuse.

---

## ⏳ Explicit Waits

The framework uses Selenium's `WebDriverWait` and `ExpectedConditions` instead of relying on fixed delays.

Example:

```java
wait.until(
    ExpectedConditions.visibilityOfElementLocated(element)
);
```

This improves test stability when interacting with dynamic web elements.

---

## 📊 Test Reports

### Extent Reports

The framework generates an HTML report using **Extent Reports**.

The report includes:

* Test execution status
* Browser information
* Failed test details
* Failure screenshots

### Allure Reports

The project also integrates **Allure Reports** for test execution reporting and visualization.

---

## 📸 Failure Screenshots

When a test fails, the TestNG listener automatically captures a screenshot.

The screenshot is attached to:

* Extent Report
* Allure Report

This helps identify UI failures during test execution.

---

## 🔐 Test Data & Configuration

Login credentials are provided through **TestNG Parameters** rather than being hard-coded inside the test methods.

Example:

```xml
<parameter name="username" value="Admin"/>
<parameter name="password" value="admin123"/>
```

Employee test data is handled using TestNG `DataProvider`.

Example:

```java
@DataProvider(name = "employeeData")
public Object[][] employeeData() {
    return new Object[][]{
        {"Mohammed", "Abdullah", "Ismail"},
        {"Ahmed", "Ali", "Hassan"},
        {"Omar", "Mohamed", "Test"}
    };
}
```

---

## 🔄 Test Execution Flow

The general UI test flow is:

```text
Start Browser
      ↓
Open OrangeHRM
      ↓
Create Page Objects
      ↓
Login
      ↓
Execute Test Scenario
      ↓
Interact with Page Objects
      ↓
Assertions
      ↓
Test Passed / Failed
      ↓
Screenshot if Failed
      ↓
Generate Reports
      ↓
Close Browser
```

---

## ▶️ How to Run

### Run Maven Tests

```bash
mvn test
```

### Run Smoke Tests

Use:

```text
testng.xml
```

### Run Regression Tests

Use:

```text
testing-regression.xml
```

The regression suite runs tests across:

```text
Chrome
Firefox
Edge
```

with parallel execution enabled.

---

## 🔑 API Authentication

The API framework reads the OrangeHRM API token from an environment variable instead of storing the token directly in the source code.

Environment variable:

```text
ORANGEHRM_API_TOKEN
```

This prevents sensitive credentials from being committed to GitHub.

---

## 🎯 Project Goals

The main goals of this project are to demonstrate practical knowledge of:

* UI Test Automation
* Selenium WebDriver
* TestNG
* Java
* Maven
* Page Object Model
* API Testing
* REST Assured
* Test Data Management
* Explicit Waits
* TestNG Parameters
* TestNG DataProviders
* TestNG Groups
* Test Dependencies
* TestNG Listeners
* Cross-Browser Testing
* Parallel Execution
* Extent Reports
* Allure Reports
* Failure Screenshots
* Reusable Automation Components
* Automation Framework Design

---

## 👨‍💻 Author

**Mohammed Ismail**

GitHub:
https://github.com/Mohammed-Ismail10

---

## 📄 Application Under Test

**OrangeHRM**

https://opensource-demo.orangehrmlive.com/
