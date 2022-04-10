package com.saucedemo.Tests;

import com.saucedemo.Pages.CartPage;
import com.saucedemo.Pages.CheckoutPage;
import com.saucedemo.Pages.LoginPage;
import com.saucedemo.Pages.ProductPage;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class CheckoutTest extends BaseTest {

    LoginPage loginPage;
    ProductPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeEach
    public void setupTests() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPage.navToLogin();
    }

    @Test
    public void positiveCheckoutTest_enterValidCheckoutInformation() {

        loginPage.loginWithDetails("standard_user", "secret_sauce");

        productsPage.getCartOptions()
                .addBackPackToCart();

        productsPage.navigateToCart();

        Assert.assertEquals(1, cartPage.getCartProductCount());

        cartPage.continueToCheckoutPage();

        checkoutPage.setFirstName("First")
                .setLastName("Second")
                .setPostcode("AB1 2CD");

        checkoutPage.continueToCheckoutOverviewPage();

    }

    @Test
    public void negativeCheckoutTest_unpopulatedFirstName() {

        loginPage.loginWithDetails("standard_user", "secret_sauce");

        productsPage.getCartOptions()
                .addBackPackToCart();

        productsPage.navigateToCart();

        Assert.assertEquals(1, cartPage.getCartProductCount());

        cartPage.continueToCheckoutPage();

        checkoutPage.setFirstName("")
                .setLastName("Second")
                .setPostcode("AB1 2CD")
                .clickContinueButton();

        Assert.assertEquals("Error: First Name is required", checkoutPage.getCheckoutError());

    }

    @Test
    public void negativeCheckoutTest_unpopulatedLastName() {

        loginPage.loginWithDetails("standard_user", "secret_sauce");

        productsPage.getCartOptions()
                .addBackPackToCart();

        productsPage.navigateToCart();

        Assert.assertEquals(1, cartPage.getCartProductCount());

        cartPage.continueToCheckoutPage();

        checkoutPage.setFirstName("First")
                .setLastName("")
                .setPostcode("AB1 2CD")
                .clickContinueButton();

        Assert.assertEquals("Error: Last Name is required", checkoutPage.getCheckoutError());

    }

    @Test
    public void negativeCheckoutTest_unpopulatedPostcode() {

        loginPage.loginWithDetails("standard_user", "secret_sauce");

        productsPage.getCartOptions()
                .addBackPackToCart();

        productsPage.navigateToCart();

        Assert.assertEquals(1, cartPage.getCartProductCount());

        cartPage.continueToCheckoutPage();

        checkoutPage.setFirstName("First")
                .setLastName("Second")
                .setPostcode("")
                .clickContinueButton();

        Assert.assertEquals("Error: Postal Code is required", checkoutPage.getCheckoutError());

    }

}
