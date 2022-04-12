package com.saucedemo.Utilities;

import java.net.MalformedURLException;
import java.net.URI;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private String getBrowserType() {
        if (System.getProperty("env.BROWSER") == null) {
            return "CHROME";
        } else {
            return System.getProperty("env.BROWSER").toUpperCase();
        }
    }

    private boolean isGridEnabled() {
        if (System.getProperty("env.GRID") == null) {
            return false;
        } else if (System.getProperty("env.GRID").contains("false")) {
            return false;
        } else {
            return true;
        }
    }

    // ** Driver setup for Selenium WebDriver */

    private void setupWebDriver() {
        switch (getBrowserType()) {
            case "CHROME":
                WebDriverManager.chromedriver();
            case "FIREFOX":
                WebDriverManager.firefoxdriver();
        }
    }

    private WebDriver createWebDriver() {
        switch (getBrowserType()) {
            case "CHROME":
                return new ChromeDriver();
            case "FIREFOX":
                return new FirefoxDriver();
        }
        return null;
    }

    // ** Driver setup for Selenium Grid RemoteWebDriver */

    private DesiredCapabilities setupRemoteWebDriver() {
        ChromeOptions chromeOptions;
        FirefoxOptions firefoxOptions;
        DesiredCapabilities capabilities;

        switch (getBrowserType()) {
            case "CHROME":
                chromeOptions = new ChromeOptions();
                capabilities = new DesiredCapabilities();
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                return capabilities;
            case "FIREFOX":
                firefoxOptions = new FirefoxOptions();
                capabilities = new DesiredCapabilities();
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                capabilities.setCapability(ChromeOptions.CAPABILITY, firefoxOptions);
                return capabilities;
            default:
                return null;

        }
    }

    private WebDriver createRemoteDriver() {
        WebDriver driver;
        String remoteURL = "http://172.17.0.1:4444/";
        try {
            driver = new RemoteWebDriver(URI.create(remoteURL).toURL(), setupRemoteWebDriver());
            return driver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void setupDriver() {
        if (!isGridEnabled()) {
            setupWebDriver();
        } else if (isGridEnabled()) {
            setupRemoteWebDriver();
        }
    }

    public WebDriver createDriver() {
        if (!isGridEnabled()) {
            return createWebDriver();
        } else if (isGridEnabled()) {
            return createRemoteDriver();
        } else {
            return null;
        }
    }

}
