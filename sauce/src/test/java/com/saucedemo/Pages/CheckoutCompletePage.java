package com.saucedemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage {

    protected static String TITLE_TEXT = "CHECKOUT: COMPLETE!";

    // *** WEB ELEMENTS ***/

    // *** CONSTRUCTOR ***/
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}