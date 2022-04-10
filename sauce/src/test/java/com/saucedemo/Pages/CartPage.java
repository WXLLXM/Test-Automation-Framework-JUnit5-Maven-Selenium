package com.saucedemo.Pages;

import com.saucedemo.PageElements.CartElements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    private CartElements cartProducts;

    protected static String TITLE_TEXT = "YOUR CART";

    // *** WEB ELEMENTS ***/
    @FindBy(how = How.ID, using = "continue-shopping")
    private WebElement continueShoppingLink;

    @FindBy(how = How.ID, using = "checkout")
    private WebElement checkoutLink;

    // *** CONSTRUCTOR ***/
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        cartProducts = new CartElements(driver);
    }

    // *** PAGE METHODS ***/
    public CartElements getCartOptions() {
        return cartProducts;
    }

    public void clickContinueShoppingButton() {
        continueShoppingLink.click();
    }

    public void clickCheckoutButton() {
        checkoutLink.click();
    }

    public void continueToCheckoutPage() {
        checkoutLink.click();
        Assert.assertTrue(isPageTitleVisible(CheckoutPage.TITLE_TEXT));
    }

}
