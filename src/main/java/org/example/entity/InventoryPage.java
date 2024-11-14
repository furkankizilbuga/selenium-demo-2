package org.example.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends Page {

    private final By addButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By productName = By.cssSelector("[data-test='inventory-item-name']");
    private final By removeButton = By.id("remove-sauce-labs-backpack");
    private final By cartButton = By.cssSelector("[data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getInventoryPageUrl() {
        return "https://www.saucedemo.com/inventory.html";
    }

    public By getRemoveButton() {
        return removeButton;
    }

    public String getProductName() {
        return getDriver().findElement(productName).getText();
    }

    public WebElement getCartButton() {
        return getDriver().findElement(cartButton);
    }

    public WebElement getAddButton() {
        return getDriver().findElement(addButton);
    }

}
