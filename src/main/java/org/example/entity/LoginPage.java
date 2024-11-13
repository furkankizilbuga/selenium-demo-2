package org.example.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By button = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getUsername() {
        WebElement usernameField = getDriver().findElement(username);
        return usernameField.getAttribute("value");
    }

    public void setUsername(String usernameInput) {
        WebElement usernameField = getDriver().findElement(username);
        usernameField.click();
        usernameField.sendKeys(usernameInput);
    }

    public String getPassword() {
        WebElement passwordField = getDriver().findElement(password);
        return passwordField.getAttribute("value");
    }

    public void setPassword(String passwordInput) {
        WebElement passwordField = getDriver().findElement(password);
        passwordField.click();
        passwordField.sendKeys(passwordInput);
    }

    public WebElement getButton() {
        return getDriver().findElement(button);
    }

    public String getErrorMessage() {
        WebElement error = getWait().until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        );
        return error.getText();
    }
}
