package com.saucedemo.Utilities;

import java.net.MalformedURLException;
import java.net.URI;

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

    // private String browserSelection =
    // System.getProperty("env.BROWSER").toUpperCase();
    // private boolean isGridEnabled =
    // System.getProperty("env.GRID").toLowerCase().contains("true");

    private String browserSelection = "CHROME";
    private boolean isGridEnabled = true;

    // ** Driver setup for Selenium WebDriver */

    private void setupWebDriver() {
        switch (browserSelection) {
            case "CHROME":
                WebDriverManager.chromedriver();
            case "FIREFOX":
                WebDriverManager.firefoxdriver();
            default:
                WebDriverManager.chromedriver();
        }
    }

    private WebDriver createWebDriver() {
        switch (browserSelection) {
            case "CHROME":
                return new ChromeDriver();
            case "FIREFOX":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }

    // ** Driver setup for Selenium Grid RemoteWebDriver */

    private DesiredCapabilities setupRemoteWebDriver() {
        ChromeOptions chromeOptions;
        FirefoxOptions firefoxOptions;
        DesiredCapabilities capabilities;

        switch (browserSelection) {
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
                chromeOptions = new ChromeOptions();
                capabilities = new DesiredCapabilities();
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                return capabilities;
        }
    }

    private WebDriver createRemoteDriver() {
        WebDriver driver;
        String remoteURL = "http://172.17.0.1/:4444/";

        try {
            driver = new RemoteWebDriver(URI.create(remoteURL).toURL(), setupRemoteWebDriver());
            return driver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void setupDriver() {
        if (!isGridEnabled) {
            setupWebDriver();
        } else if (isGridEnabled) {
            setupRemoteWebDriver();
        } else {

        }
    }

    public WebDriver createDriver() {
        if (!isGridEnabled) {
            return createWebDriver();
        } else if (isGridEnabled) {
            return createRemoteDriver();
        } else {
            return null;
        }
    }

}
