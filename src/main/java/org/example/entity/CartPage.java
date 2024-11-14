package org.example.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends Page {

    private By removeButton = By.xpath("//button[text()='Remove']");
    private By continueButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private By productName = By.cssSelector("[data-test='inventory-item-name']");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getCartPageUrl() {
        return "https://www.saucedemo.com/cart.html";
    }

    public WebElement getProductName() {
        return getDriver().findElement(productName);
    }


    public WebElement getRemoveButton() {
        return getDriver().findElement(removeButton);
    }


    public WebElement getContinueButton() {
        return getDriver().findElement(continueButton);
    }

    public WebElement getCheckoutButton() {
        return getDriver().findElement(checkoutButton);
    }

}
