package TestCases;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import helper.BaseTest;
import helper.TestListener;


@Listeners(TestListener.class)
public class SeleniumAssertionsPracticeTest extends BaseTest {
	
    private final String TEST_URL = "https://www.saucedemo.com/";

    @Test(priority = 1)
    public void testPageTitle() {
        // String assertions
        assertEquals(driver.getTitle(), "Swag Labs", "Page title doesn't match");
        assertNotEquals(driver.getTitle(), "Wrong Title", "Title should not match");
        assertTrue(driver.getTitle().contains("Swag"), "Title should contain 'Swag'");
        assertFalse(driver.getTitle().isEmpty(), "Title should not be empty");
    }

    @Test(priority = 2)
    public void testLoginFormElements() {
        // Boolean assertions
        assertTrue(driver.findElement(By.id("user-name")).isDisplayed(), "Username field should be displayed");
        assertTrue(driver.findElement(By.id("password")).isEnabled(), "Password field should be enabled");
        assertFalse(driver.findElement(By.id("login-button")).isSelected(), "Login button should not be selected");
        
        // WebElement assertions
        WebElement loginButton = driver.findElement(By.id("login-button"));
        assertEquals(loginButton.getDomAttribute("value"), "Login", "Login button text mismatch");
        assertEquals(loginButton.getCssValue("font-weight"), "400", "Font weight should be bold");
    }

    @Test(priority = 3)
    public void testLoginFunctionality() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        // URL assertions after login
        assertNotEquals(driver.getCurrentUrl(), TEST_URL, "URL should change after login");
        assertTrue(driver.getCurrentUrl().contains("inventory.html"), "URL should contain 'inventory.html'");
        
        // Page content assertions
        assertNotNull(driver.findElement(By.className("inventory_list")), "Inventory list should exist");
    }

    @Test(priority = 4)
    public void testInventoryPage() {
        // List size assertions
        List<WebElement> inventoryItems = driver.findElements(By.className("inventory_item"));
        assertEquals(inventoryItems.size(), 6, "There should be 6 inventory items");
        assertNotEquals(inventoryItems.size(), 0, "Inventory items count should not be zero");
        
        // Numeric assertions
        WebElement firstItem = inventoryItems.get(0);
        String priceText = firstItem.findElement(By.className("inventory_item_price")).getText();
        double price = Double.parseDouble(priceText.replace("$", ""));
        assertTrue(price > 0, "Price should be greater than 0");
    }
/*
    @Test(priority = 5)
    public void testAddToCart() {
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));
        addToCartButtons.get(0).click();
        
        // Shopping cart badge assertion
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));

        Wait<WebDriver> ww = new WebDriverWait(driver, Duration.ofSeconds(3));
        ww.until(d -> cartBadge.isDisplayed());
        
        assertEquals(cartBadge.getText(), "1", "Cart should show 1 item");
        
        // Element state change assertions
        WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
        assertTrue(removeButton.isDisplayed(), "Remove button should appear after adding to cart");
    }

    @Test(priority = 6)
    public void testNullAndObjectAssertions() {
        // Null assertions
        List<WebElement> nonExistentElements = driver.findElements(By.id("non-existent-element"));
        assertNull(nonExistentElements.size() == 0 ? null : "dummy", "Should return empty list (treated as null)");
        assertNotNull(driver, "Driver object should not be null");
        
        // Same/NotSame assertions
        WebElement cart1 = driver.findElement(By.className("shopping_cart_link"));
        WebElement cart2 = driver.findElement(By.className("shopping_cart_link"));
        assertSame(cart1, cart1, "Should be the same object");
        assertNotSame(cart1, cart2, "Should be different objects");
    }
*/
}