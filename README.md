# 🔍 Page Object Model with Page Factory - Selenium Test Automation Framework

This repository contains a modular, extensible, and robust **Java-based Test Automation Framework** using:
- **Selenium WebDriver**
- **TestNG**
- **Page Object Model (POM)** with **Page Factory**
- **ExtentReports** for HTML reporting
- **Log4j** for logging
- **Excel** as a Data Provider for test inputs
- **Jenkins Integration Ready**

---

## 🚀 Features

✅ Page Object Model with PageFactory using `@FindBy` and `AjaxElementLocatorFactory`  
✅ Data-Driven Testing using Excel (Apache POI)  
✅ Centralized test lifecycle using `BaseTest.java`  
✅ Reusable utility methods (`scroll`, `selectDropdown`, `getRandomNumber`)  
✅ Dynamic test data generation for registration flows  
✅ Custom reporting with screenshots using **ExtentReports**  
✅ Logging via Log4j  
✅ Test control via `Test_Suite` Excel sheet  
✅ Jenkins-compatible structure  
✅ Scalable for API + Mobile testing extension

---

## 🧾 Project Structure

## 🧾 Project Structure

project-root/
│
├── src/
│ ├── main/
│ │ └── java/
│ │ └── pom/example/
│ │ ├── base/ # Base classes (BaseTest, Page)
│ │ ├── listeners/ # TestNG listeners (CustomListener)
│ │ ├── locators/ # Page locators using PageFactory
│ │ ├── pages/ # Page Actions (LoginPage, RegisterAccountPage, etc.)
│ │ ├── reports/ # Extent Report setup
│ │ └── utilities/ # Excel Reader, Screenshot, Dropdown etc.
│ └── test/
│ └── java/
│ └── pom/example/testcases/ # Test classes (LoginTest, RegisterAccountTest)
│
├── testdata/
│ └── TestData.xlsx # Excel sheet with test data (LoginTest, RegisterAccountTest, Test_Suite)
│
├── reports/
│ └── index.html # Extent HTML report (generated after execution)
│
├── log/
│ └── execution.log # Log4j logs
│
├── testng.xml # TestNG suite file
├── log4j.properties # Log4j config
└── pom.xml # Maven dependencies

yaml
Copy
Edit

---

## 📦 Tools & Tech Stack

| Component        | Description |
|------------------|-------------|
| **Language**     | Java 11+ |
| **Automation**   | Selenium WebDriver |
| **Test Framework** | TestNG |
| **Design Pattern** | Page Object Model with PageFactory |
| **Reporting**    | ExtentReports |
| **Logging**      | Log4j |
| **Data Source**  | Excel using Apache POI |
| **Build Tool**   | Maven |
| **CI/CD**        | Jenkins (Optional) |

---

## 📁 Test Data Excel Format

📄 `TestData.xlsx` contains:
- **Test_Suite**: Controls which tests to run via `Runmode = Y/N`
- **LoginTest**: email, password
- **RegisterAccountTest**: First name, Last name, Phone, Password

---

## 🧪 How to Run the Tests

### ✅ Option 1: IntelliJ or Eclipse

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/<your-repo-name>.git
   cd <your-repo-name>
Install dependencies:

Right-click on pom.xml → Maven → Reload Project

Run tests:

Via testng.xml OR individual test classes

✅ Option 2: Command Line
bash
Copy
Edit
mvn clean test
Reports will be available under /reports/index.html
Logs saved under /log/execution.log

✅ Option 3: Jenkins
Create a Freestyle Job

Git SCM → Add repo URL

Build → mvn clean test

Post-build action:

Publish Extent HTML Report from reports/

📸 Screenshots & Reports
Captured for important checkpoints (e.g. error messages, success screens)

Stored inside /screenshots/ folder (configurable)

Integrated into ExtentReports for visual logs

🔐 Sample Test Cases
✅ Login with invalid credentials (error validation)

✅ Register account with randomized data (dynamic email, phone)

✅ Validate landing to HomePage after login

✅ Sign out and navigate back to login screen

🙌 Contributing
Feel free to fork this repo, improve and raise PRs for:

API test integration

Retry Analyzer

Dockerized execution

Parallel thread execution via TestNG

📄 License
This project is licensed under the MIT License.
