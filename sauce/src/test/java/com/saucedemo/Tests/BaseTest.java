package com.saucedemo.Tests;

import com.saucedemo.Utilities.DriverFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    public WebDriver driver;
    static DriverFactory driverFactory = new DriverFactory();

    @BeforeAll
    private static void setup() {
        driverFactory.setupDriver();
    }

    @BeforeEach
    private void setupTest() {
        driver = driverFactory.createDriver();
    }

    @AfterEach
    private void teardownTest() {
        driver.quit();
    }

}
