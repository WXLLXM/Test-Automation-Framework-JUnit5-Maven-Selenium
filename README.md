
# Test Automation Framework: JUnit5, Maven, Selenium.

This test automation framework has been designed using the Page Object design pattern using Selenium, JUnit5 and Maven. The test framework has been built around the https://www.saucedemo.com/ website.


## Features

- Sequential or parallel execution
- Browser selection
- Containerised Selenium Grid



## Download

Fork my project from GitHub:

```bash
  Git fork....
  cd my-project
```
    

## Running Tests

The following environment variables and maven commands are available to drive this framework.
```bash
  -Denv.BROWSER=chrome (Selection of chrome or firefox currently available, chrome by default)
  -Dtest=TestClass (To execute all tests within a TestClass.class file)
  -Denv.PARALLEL=true (To run tests in parallel, if not enabled tests will run sequentially)
  -Denv.GRID=true (To run tests against Selenium Grid)
```

To run all tests:

```bash
  mvn test
```

To run tests with a specific browser:

```bash
  mvn -Denv.BROWSER=firefox test
```

To run tests within a specific class:

```bash
  mvn -Dtest=LoginTest test
```

To run tests in parallel:

```bash
  mvn -Dtest=LoginTest -Denv.PARALLEL=true test
```

To run tests using selenium grid:

```bash
  mvn -Dtest=LoginTest -Denv.GRID=true test
```

To run tests in parallel using selenium grid:

```bash
  mvn -Denv.BROWSER=chrome -Dtest=LoginTest -Denv.PARALLEL=true -Denv.GRID=true test
```
## Whats Next

- Better error handling
- Better logging
- Logic to determine if selenium grid is running in docker before executing tests using selenium grid