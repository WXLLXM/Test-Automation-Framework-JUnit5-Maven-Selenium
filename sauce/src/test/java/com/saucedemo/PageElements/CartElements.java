package com.saucedemo.PageElements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartElements {

    public CartElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // *** Backpack ***/
    @FindBy(how = How.XPATH, using = "//*[@id='cart_contents_container']/div/div[1]/div[2]")
    private WebElement backpack;

    @FindBy(how = How.ID, using = "item_1_title_link")
    private WebElement backpack_productLink;

    @FindBy(how = How.ID, using = "remove-sauce-labs-backpack")
    private WebElement Backpack_RemoveFromCart;

    public String getBackpackDetails() {
        return backpack.getText();
    }

    public void clickBackpackProductLink() {
        backpack_productLink.click();
    }

    public CartElements removeBackPackFromCart() {
        Backpack_RemoveFromCart.click();
        return this;
    }

    // *** Bike Light ***/
    @FindBy(how = How.XPATH, using = "//*[@id='cart_contents_container']/div/div[2]/div[2]")
    private WebElement bikeLight;

    @FindBy(how = How.ID, using = "item_2_title_link")
    private WebElement bikeLight_productLink;

    @FindBy(how = How.ID, using = "remove-sauce-labs-bike-light")
    private WebElement bikeLight_RemoveFromCart;

    public String getBikeLightDetails() {
        return bikeLight.getText();
    }

    public void clickBikeLightProductLink() {
        bikeLight_productLink.click();
    }

    public CartElements removeBikeLightFromCart() {
        bikeLight_RemoveFromCart.click();
        return this;
    }

    // *** Bolt T-Shirt ***/
    @FindBy(how = How.XPATH, using = "//*[@id='cart_contents_container']/div/div[3]/div[2]")
    private WebElement boltTShirt;

    @FindBy(how = How.ID, using = "item_3_title_link")
    private WebElement boltTShirt_productLink;

    @FindBy(how = How.ID, using = "remove-sauce-labs-bolt-t-shirt")
    private WebElement boltTShirt_RemoveFromCart;

    public String getBoltTShirtDetails() {
        return boltTShirt.getText();
    }

    public void clickBoltTShirtProductLink() {
        boltTShirt_productLink.click();
    }

    public CartElements removeBoltTShirtFromCart() {
        boltTShirt_RemoveFromCart.click();
        return this;
    }

    // *** Fleece Jacket ***/
    @FindBy(how = How.XPATH, using = "//*[@id='cart_contents_container']/div/div[4]/div[2]")
    private WebElement fleeceJacket;

    @FindBy(how = How.ID, using = "item_4_title_link")
    private WebElement fleeceJacket_productLink;

    @FindBy(how = How.ID, using = "remove-sauce-labs-fleece-jacket")
    private WebElement fleeceJacket_RemoveFromCart;

    public String getFleeceJacketDetails() {
        return fleeceJacket.getText();
    }

    public void clickFleeceJacketProductLink() {
        fleeceJacket_productLink.click();
    }

    public CartElements removeFleeceJacketFromCart() {
        fleeceJacket_RemoveFromCart.click();
        return this;
    }

    // *** Onesie***/
    @FindBy(how = How.XPATH, using = "//*[@id='cart_contents_container']/div/div[5]/div[2]")
    private WebElement onesie;

    @FindBy(how = How.ID, using = "item_5_title_link")
    private WebElement onesie_productLink;

    @FindBy(how = How.ID, using = "remove-sauce-labs-onesie")
    private WebElement onesie_RemoveFromCart;

    public String getOnesieDetails() {
        return onesie.getText();
    }

    public void clickOnsesieProductLink() {
        onesie_productLink.click();
    }

    public CartElements removeOnesieFromCart() {
        onesie_RemoveFromCart.click();
        return this;
    }

    // *** Red T-Shirt ***/
    @FindBy(how = How.XPATH, using = "//*[@id='cart_contents_container']/div/div[6]/div[2]")
    private WebElement redTShirt;

    @FindBy(how = How.ID, using = "item_6_title_link")
    private WebElement redTShirt_productLink;

    @FindBy(how = How.ID, using = "remove-test.allthethings()-t-shirt-(red)")
    private WebElement redTShirt_RemoveFromCart;

    public String getRedTShirtDetails() {
        return redTShirt.getText();
    }

    public void clickRedTShirtProductLink() {
        redTShirt_productLink.click();
    }

    public CartElements removeRedTShirtFromCart() {
        redTShirt_RemoveFromCart.click();
        return this;
    }

}
