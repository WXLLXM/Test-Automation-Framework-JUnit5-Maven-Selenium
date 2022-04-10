package com.saucedemo.Tests;

import com.saucedemo.Pages.CartPage;
import com.saucedemo.Pages.LoginPage;
import com.saucedemo.Pages.ProductPage;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class ProductTest extends BaseTest {

    LoginPage loginPage;
    ProductPage productsPage;
    CartPage cartPage;

    @BeforeEach
    public void setupTests() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        loginPage.navToLogin();
    }

    @Test
    public void positiveProductTest_addProductToCart() {

        loginPage.loginWithDetails("standard_user", "secret_sauce");

        productsPage.getCartOptions()
                .addBackPackToCart();

        productsPage.navigateToCart();

        Assert.assertEquals(1, cartPage.getCartProductCount());

    }

    @Test
    public void positiveProductTest_addAllProductsToCart() {

        loginPage.loginWithDetails("standard_user", "secret_sauce");

        productsPage.getCartOptions()
                .addBackPackToCart()
                .addBikeLightToCart()
                .addBoltTShirtToCart()
                .addFleeceJacketToCart()
                .addOnesieToCart()
                .addRedTShirtToCart();

        productsPage.navigateToCart();

        Assert.assertEquals(6, cartPage.getCartProductCount());

    }

    @Test
    public void positiveProductTest_removeProductFromCart() {

        loginPage.loginWithDetails("standard_user", "secret_sauce");

        productsPage.getCartOptions()
                .addBackPackToCart()
                .addBikeLightToCart()
                .addBoltTShirtToCart();

        productsPage.navigateToCart();

        Assert.assertEquals(3, cartPage.getCartProductCount());

        cartPage.getCartOptions()
                .removeBackPackFromCart();

        Assert.assertEquals(2, cartPage.getCartProductCount());

    }

    @Test
    public void positiveProductTest_removeAllProductsFromCart() {

        loginPage.loginWithDetails("standard_user", "secret_sauce");

        productsPage.getCartOptions()
                .addBackPackToCart()
                .addBikeLightToCart()
                .addBoltTShirtToCart();

        productsPage.navigateToCart();

        Assert.assertEquals(3, cartPage.getCartProductCount());

        cartPage.getCartOptions()
                .removeBackPackFromCart()
                .removeBikeLightFromCart()
                .removeBoltTShirtFromCart();

        Assert.assertEquals(0, cartPage.getCartProductCount());

    }

}
