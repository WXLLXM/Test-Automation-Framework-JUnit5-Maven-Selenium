package com.saucedemo.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private String loginPageURL = "https://www.saucedemo.com/";

    // *** WEB ELEMENTS ***/
    @FindBy(how = How.CLASS_NAME, using = "login_logo")
    private WebElement loginLogo;

    @FindBy(how = How.ID, using = "user-name")
    private WebElement usernameField;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "login-button")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//div[@class='error-message-container error']//child::h3")
    private WebElement loginError;

    // *** CONSTRUCTOR ***/
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // *** PAGE METHODS ***/
    public void navToLogin() {
        driver.get(loginPageURL);
        Assert.assertTrue(isPageLogoVisible(loginLogo));
    }

    // Page method used for positive tests - Asserts Products Page is visible after
    // login.
    public void loginWithDetails(String username, String password) {
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
        Assert.assertTrue(isPageTitleVisible(ProductPage.TITLE_TEXT));
    }

    public String getLoginError() {
        return loginError.getText();
    }

    public LoginPage setUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}