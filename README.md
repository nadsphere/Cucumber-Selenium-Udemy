# Cucumber Selenium Udemy

A BDD (Behavior-Driven Development) test automation project using Cucumber with Selenium WebDriver in Java. Demonstrates end-to-end UI testing with the Page Object Model pattern.

## Tech Stack

| Component | Technology |
|---|---|
| Language | Java 17 |
| Build Tool | Maven |
| UI Automation | Selenium WebDriver 4.3.0 |
| BDD Framework | Cucumber 7.5.0 |
| Test Runner | TestNG |
| DI Container | PicoContainer |
| Reporting | ExtentReports 5.0.9 + cucumber7 adapter |
| HTML Reports | maven-cucumber-reporting |
| Driver Management | WebDriverManager (bonigarcia) |

## Project Structure

```
src/test/
├── java/
│   ├── Base/
│   │   └── BaseUtil.java          # WebDriver holder + config loader
│   ├── Steps/
│   │   ├── Hooks.java             # @Before, @After, @BeforeStep, @AfterStep
│   │   └── LoginSteps.java        # Step definitions
│   ├── pages/
│   │   ├── LoginPage.java         # Page Object - login page
│   │   └── UserForm.java          # Page Object - user form page
│   └── runner/
│       └── TestRunner.java         # Cucumber + TestNG runner
└── resources/
    ├── config.properties           # Application & browser config
    └── features/
        └── Login.feature           # Gherkin scenarios
```

## Configuration

All settings are managed via `src/test/resources/config.properties`:

| Key | Description | Default |
|---|---|---|
| `base.url` | Application under test | `https://demosite.executeautomation.com/` |
| `login.username` | Test username | `admin` |
| `login.password` | Test password | `admin123` |
| `browser` | Browser: `chrome`, `firefox`, `edge` | `chrome` |
| `browser.headless` | Run browser in headless mode | `false` |
| `wait.timeout` | Explicit wait timeout (seconds) | `10` |

## How to Run

```bash
mvn clean verify
```

Reports are generated at:
- **ExtentReports:** `test-output/SparkReport*.html`
- **Cucumber HTML:** `target/cucumber-html-reports/`

## Running Specific Tests

Filter tests using tags or scenario name via Maven:

```bash
# By tag
mvn clean verify -Dcucumber.filter.tags="@Debug"
mvn clean verify -Dcucumber.filter.tags="@Smoke"

# By name (partial match)
mvn clean verify -Dcucumber.filter.name="Login with correct credential"

# Exclude by tag
mvn clean verify -Dcucumber.filter.tags="not @Ignore"

# Combine tags
mvn clean verify -Dcucumber.filter.tags="@Smoke and @Login"
mvn clean verify -Dcucumber.filter.tags="@Smoke or @Regression"
```

Add tags to any scenario in `.feature` files:

```gherkin
@Smoke
Scenario: Login with correct credential
  Given I navigate to login page
  ...
```

## Key Features

- **Page Object Model** -- locators and actions encapsulated per page
- **Dependency Injection** -- WebDriver shared across steps via PicoContainer
- **Explicit Waits** -- no `Thread.sleep`, uses `WebDriverWait` throughout
- **Multi-browser** -- supports Chrome, Firefox, Edge via config
- **Screenshot on failure** -- automatically captured and embedded in ExtentReports
- **Parallel execution** -- via TestNG data provider
- **Data-driven testing** -- credentials from Cucumber DataTable

## License

[MIT](LICENSE)
