package com.saucedemo.Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BasePage {

    protected static String TITLE_TEXT = "CHECKOUT: OVERVIEW";

    // *** WEB ELEMENTS ***/
    @FindBy(how = How.CLASS_NAME, using = "summary_subtotal_label")
    private WebElement cartItemTotal;

    @FindBy(how = How.CLASS_NAME, using = "summary_tax_label")
    private WebElement cartTax;

    @FindBy(how = How.CLASS_NAME, using = "summary_total_label")
    private WebElement cartTotal;

    @FindBy(how = How.ID_OR_NAME, using = "finish")
    private WebElement finishButton;

    @FindBy(how = How.ID_OR_NAME, using = "cancel")
    private WebElement cancelButton;

    private String cartItemPriceList = "inventory_item_price";

    // *** CONSTRUCTOR ***/
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // *** PAGE METHODS ***/

    // Helper method for calculate methods (String)
    private double calculateAndReturnCartItemTotal() {
        double cartItemTotal = 0.0;
        List<WebElement> listOfItemPrices = driver.findElements(By.className(cartItemPriceList));
        for (int i = 0; i < listOfItemPrices.size(); i++) {
            String itemPrice = listOfItemPrices.get(i).getText();
            String itemPriceWithoutDollaSign = itemPrice.replace("$", "");
            try {
                double itemPriceDouble = Double.parseDouble(itemPriceWithoutDollaSign);
                cartItemTotal = cartItemTotal + itemPriceDouble;
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        return cartItemTotal;
    }

    public String calculateCartItemTotal() {
        Double cartItemTotal = calculateAndReturnCartItemTotal();
        return "Item total: $" + cartItemTotal.toString();
    }

    public String calculateCartTaxTotal() {
        double cartTax = calculateAndReturnCartItemTotal() * 0.08;
        Double cartTaxRounded = Math.round(cartTax * 100.00) / 100.00;
        return "Tax: $" + cartTaxRounded.toString() + "0";
    }

    public String calculateCartTotal() {
        double cartTax = calculateAndReturnCartItemTotal() * 0.08;
        double cartTaxRounded = Math.round(cartTax * 100.00) / 100.00;
        Double cartTotal = cartTaxRounded + calculateAndReturnCartItemTotal();
        return "Total: $" + cartTotal.toString();
    }

    public String getCartItemTotal() {
        String cartItemTotalNumber = cartItemTotal.getText();
        return cartItemTotalNumber;
    }

    public String getCartTaxTotal() {
        return cartTax.getText();
    }

    public String getCartTotal() {
        return cartTotal.getText();
    }

    public void continueToCheckoutCompletePage() {
        finishButton.click();
        Assert.assertTrue(isPageTitleVisible(CheckoutCompletePage.TITLE_TEXT));
    }

}