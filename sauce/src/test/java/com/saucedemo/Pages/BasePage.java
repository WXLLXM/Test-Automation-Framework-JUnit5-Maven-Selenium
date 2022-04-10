package com.saucedemo.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    @FindBy(how = How.CLASS_NAME, using = "title")
    private WebElement pageTitle;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected boolean isPageTitleVisible(String pageTitleText) {
        if (pageTitle.isDisplayed()) {
            if (pageTitle.getText().equals(pageTitleText)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    protected boolean isPageLogoVisible(WebElement pageLogo) {
        if (pageLogo.isDisplayed()) {
            return true;
        }
        return false;
    }

    public int getCartProductCount() {
        List<WebElement> listOfProductsInCart = driver.findElements(By.className("cart_item"));
        return listOfProductsInCart.size();
    }

}
