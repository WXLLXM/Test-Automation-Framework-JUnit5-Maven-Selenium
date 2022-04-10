package com.saucedemo.Tests;

import com.saucedemo.Pages.CartPage;
import com.saucedemo.Pages.CheckoutCompletePage;
import com.saucedemo.Pages.CheckoutPage;
import com.saucedemo.Pages.LoginPage;
import com.saucedemo.Pages.ProductPage;
import com.saucedemo.Pages.CheckoutOverviewPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class CheckoutOverviewTest extends BaseTest {

        LoginPage loginPage;
        ProductPage productsPage;
        CartPage cartPage;
        CheckoutPage checkoutPage;
        CheckoutOverviewPage checkoutOverviewPage;
        CheckoutCompletePage checkoutCompletePage;

        @BeforeEach
        public void setupTests() {
                loginPage = new LoginPage(driver);
                productsPage = new ProductPage(driver);
                cartPage = new CartPage(driver);
                checkoutPage = new CheckoutPage(driver);
                checkoutOverviewPage = new CheckoutOverviewPage(driver);
                checkoutCompletePage = new CheckoutCompletePage(driver);

                loginPage.navToLogin();
        }

        @Test
        public void positiveCheckoutTest_enterValidCheckoutInformation() {

                loginPage.loginWithDetails("standard_user", "secret_sauce");

                productsPage.getCartOptions()
                                .addBackPackToCart()
                                .addBikeLightToCart();

                productsPage.navigateToCart();

                Assert.assertEquals(2, cartPage.getCartProductCount());

                cartPage.continueToCheckoutPage();

                checkoutPage.setFirstName("First")
                                .setLastName("Second")
                                .setPostcode("AB1 2CD");

                checkoutPage.continueToCheckoutOverviewPage();

                Assert.assertEquals(2, checkoutOverviewPage.getCartProductCount());

                Assert.assertEquals(checkoutOverviewPage.calculateCartItemTotal(),
                                checkoutOverviewPage.calculateCartItemTotal());

                Assert.assertEquals(checkoutOverviewPage.getCartTaxTotal(),
                                checkoutOverviewPage.calculateCartTaxTotal());

                Assert.assertEquals(checkoutOverviewPage.getCartTotal(),
                                checkoutOverviewPage.calculateCartTotal());

                checkoutOverviewPage.continueToCheckoutCompletePage();

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

                Assert.assertEquals("Error: First Name is required",
                                checkoutPage.getCheckoutError());

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

                Assert.assertEquals("Error: Last Name is required",
                                checkoutPage.getCheckoutError());

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

                Assert.assertEquals("Error: Postal Code is required",
                                checkoutPage.getCheckoutError());

        }

}
