package com.saucedemo.Pages;

import com.saucedemo.PageElements.ProductElements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    private ProductElements products;

    protected static String TITLE_TEXT = "PRODUCTS";

    // *** WEB ELEMENTS ***/
    @FindBy(how = How.CLASS_NAME, using = "shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy(how = How.ID, using = "react-burger-menu-btn")
    private WebElement burgerLink;

    @FindBy(how = How.ID, using = "inventory_sidebar_link")
    private WebElement burgerAllItemsLink;

    @FindBy(how = How.ID, using = "about_sidebar_link")
    private WebElement burgerAboutLink;

    @FindBy(how = How.ID, using = "logout_sidebar_link")
    private WebElement burgerLogoutLink;

    @FindBy(how = How.ID, using = "reset_sidebar_link")
    private WebElement burgerResetAppStateLink;

    // *** CONSTRUCTOR ***/
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        products = new ProductElements(driver);
    }

    // *** PAGE METHODS ***/
    public ProductElements getCartOptions() {
        return products;
    }

    public void navigateToCart() {
        shoppingCartLink.click();
        Assert.assertTrue(isPageTitleVisible(CartPage.TITLE_TEXT));
    }

    public void clickLeftHandBugerMenuIcon() {
        burgerLink.click();
        burgerAllItemsLink.click();
    }

}
