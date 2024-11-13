import org.example.entity.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTests extends BaseTest {

    private LoginPage loginPage;
    private String testUsername;
    private String testPassword;

    @BeforeEach
    void loginSetup() {
        loginPage = new LoginPage(driver, wait);
    }

    @Test
    public void test_successful_login() {
        //Arrange
        testUsername = "standard_user";
        testPassword = "secret_sauce";

        loginPage.setUsername(testUsername);
        loginPage.setPassword(testPassword);

        //Act
        loginPage.getButton().click();

        //Assert
        String url = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory.html", url);
    }

    @Test
    public void test_unsuccessful_login() {
        //Arrange
        testUsername = "wrong_user";
        testPassword = "secret_sauce";

        loginPage.setUsername(testUsername);
        loginPage.setPassword(testPassword);

        //Act
        loginPage.getButton().click();

        //Assert
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']"))
        );


        String url = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/", url);
        assertTrue(errorMessage.isDisplayed());
        assertEquals(errorMessage.getText(), loginPage.getErrorMessage());

    }

}
