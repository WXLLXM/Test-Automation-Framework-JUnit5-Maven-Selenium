package com.saucedemo.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    protected static String TITLE_TEXT = "CHECKOUT: YOUR INFORMATION";

    // *** WEB ELEMENTS ***/
    @FindBy(how = How.ID, using = "first-name")
    private WebElement firstNameField;

    @FindBy(how = How.ID, using = "last-name")
    private WebElement lastNameField;

    @FindBy(how = How.ID, using = "postal-code")
    private WebElement postCodeField;

    @FindBy(how = How.ID, using = "continue")
    private WebElement continueButton;

    @FindBy(how = How.ID, using = "cancel")
    private WebElement cancelButton;

    @FindBy(how = How.XPATH, using = "//div[@class='error-message-container error']//child::h3")
    private WebElement checkoutError;

    // *** CONSTRUCTOR ***/
    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // *** PAGE METHODS ***/
    public CheckoutPage setFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CheckoutPage setLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CheckoutPage setPostcode(String postcode) {
        postCodeField.clear();
        postCodeField.sendKeys(postcode);
        return this;
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public String getCheckoutError() {
        return checkoutError.getText();
    }

    public void continueToCheckoutOverviewPage() {
        continueButton.click();
        Assert.assertTrue(isPageTitleVisible(CheckoutOverviewPage.TITLE_TEXT));
    }

}