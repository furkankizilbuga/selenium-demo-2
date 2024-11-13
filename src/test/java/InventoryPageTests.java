import org.example.entity.InventoryPage;
import org.example.entity.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryPageTests extends BaseTest {

    private InventoryPage inventoryPage;

    @BeforeEach
    void inventorySetup() {
        inventoryPage = new InventoryPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);

        //Login Act
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.getButton().click();

        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void adds_to_cart_successfully() {

        inventoryPage.getAddButton().click();
        String productNameInventory = inventoryPage.getProductName();

        inventoryPage.getCartButton().click();

        String productNameCart = driver.findElement(By.cssSelector("[data-test='inventory-item-name']")).getText();

        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        assertEquals(productNameInventory, productNameCart);

    }

    @Test
    public void removes_from_cart_successfully() {

        //Add to Cart
        inventoryPage.getAddButton().click();
        String productNameInventory = inventoryPage.getProductName();

        //Remove From Cart
        WebElement removeButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(inventoryPage.getRemoveButton())
        );
        removeButton.click();

        //Go to Cart
        inventoryPage.getCartButton().click();

        boolean isRemoved = driver.findElements(By.cssSelector("[data-test='inventory-item-name']")).isEmpty();

        //Check item
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        assertTrue(isRemoved);
    }
}
