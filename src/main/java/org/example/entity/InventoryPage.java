package org.example.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends Page {

    private By addButton;
    private By cartButton;

    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

}
