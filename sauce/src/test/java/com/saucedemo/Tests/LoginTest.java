package com.saucedemo.Tests;

import com.saucedemo.Pages.LoginPage;
import com.saucedemo.Pages.ProductPage;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class LoginTest extends BaseTest {

        LoginPage loginPage;
        ProductPage productsPage;

        @BeforeEach
        public void setupTests() {

                loginPage = new LoginPage(driver);
                productsPage = new ProductPage(driver);

                loginPage.navToLogin();
        }

        @Test
        public void positiveLoginTest_standardUser() {

                loginPage.loginWithDetails("standard_user", "secret_sauce");

        }

        @Test
        public void negativeLoginTest_invalidUsername() {

                loginPage.setUsername("invalid_user")
                                .setPassword("secret_sauce")
                                .clickLoginButton();

                Assert.assertEquals(
                                loginPage.getLoginError(),
                                "Epic sadface: Username and password do not match any user in this service");
        }

        @Test
        public void negativeLoginTest_invalidPassword() {

                loginPage.setUsername("standard_user")
                                .setPassword("invalid_password")
                                .clickLoginButton();

                Assert.assertEquals(
                                loginPage.getLoginError(),
                                "Epic sadface: Username and password do not match any user in this service");
        }

        @Test
        public void negativeLoginTest_unpopulatedUsername() {

                loginPage.setUsername("")
                                .setPassword("secret_sauce")
                                .clickLoginButton();

                Assert.assertEquals(
                                loginPage.getLoginError(),
                                "Epic sadface: Username is required");
        }

        @Test
        public void negativeLoginTest_unpopulatedPassword() {

                loginPage.setUsername("standard_user")
                                .setPassword("")
                                .clickLoginButton();

                Assert.assertEquals(
                                loginPage.getLoginError(),
                                "Epic sadface: Password is required");
        }

        @Test
        public void negativeLoginTest_unpopulatedUsernamePassword() {

                loginPage.setUsername("")
                                .setPassword("")
                                .clickLoginButton();

                Assert.assertEquals(
                                loginPage.getLoginError(),
                                "Epic sadface: Username is required");
        }

}
