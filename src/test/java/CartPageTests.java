import org.example.entity.CartPage;
import org.example.entity.InventoryPage;
import org.example.entity.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class CartPageTests extends BaseTest {

    private CartPage cartPage;
    private InventoryPage inventoryPage;

    @BeforeEach
    void cartSetup() {
        cartPage = new CartPage(driver, wait);

        //Login
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.getButton().click();

        //Add to Cart and Open Cart
        inventoryPage = new InventoryPage(driver, wait);
        inventoryPage.getAddButton().click();
        inventoryPage.getCartButton().click();

        assertEquals(driver.getCurrentUrl(), cartPage.getCartPageUrl());
    }

    @Test
    public void right_product_is_in_cart() {
        String expected = cartPage.getProductName().getText();
        String productName = inventoryPage.getProductName();

        assertEquals(expected, productName);
    }

    @Test
    public void remove_button_works() {
        //Arrange
        WebElement removeButton = cartPage.getRemoveButton();

        //Act
        removeButton.click();

        //Assert
        try {

            WebElement productName = cartPage.getProductName();
            fail("Product was not removed from the cart!");

        } catch(NoSuchElementException e) {

            System.out.println("Product is removed");

        }

    }

    @Test
    public void continue_button_works() {
        //Arrange
        WebElement continueButton = cartPage.getContinueButton();

        //Act
        continueButton.click();

        //Arrange
        assertEquals(driver.getCurrentUrl(), inventoryPage.getInventoryPageUrl());
    }

    @Test
    public void checkout_button_works() {
        //Arrange
        WebElement checkoutButton = cartPage.getCheckoutButton();

        //Act
        checkoutButton.click();

        //Assert
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
    }


}
