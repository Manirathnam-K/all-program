package page_naigation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class tab_handle {



    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // 1. Open Myntra
            driver.get("https://www.myntra.com/");

            // optional: close cookie/login popup if present
            try {
                WebElement popupClose = wait.until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector("button[data-modal-close]")));
                popupClose.click();
            } catch (Exception ignored) { /* no popup */ }

            // 2. Search for "s24"
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@placeholder='Search for products, brands and more']")));
            searchBox.sendKeys("s24");
            searchBox.sendKeys(Keys.ENTER);

            // 3. Wait for product results list to appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//ul[contains(@class,'results-base') or contains(@class,'results-list')]")));

            // 4. Click the first appearing product
            WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//li[contains(@class,'product-base') or contains(@class,'product')])[1]//a")));
            // open product (Myntra usually opens in same tab, but sometimes new tab) 
            firstProduct.click();

            // 5. Switch to newly opened tab (if any). If only one tab, remain on it.
            String currentHandle = driver.getWindowHandle();
            Set<String> handlesBefore = driver.getWindowHandles();
            // small wait to allow new tab to open
            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

            List<String> handlesList = new ArrayList<>(driver.getWindowHandles());
            if (handlesList.size() > 1) {
                // choose the last opened handle
                String lastHandle = handlesList.get(handlesList.size() - 1);
                driver.switchTo().window(lastHandle);
                System.out.println("Switched to new tab: " + lastHandle);
            } else {
                // same tab
                driver.switchTo().window(currentHandle);
                System.out.println("Product opened in same tab.");
            }

            // 6. Wait for product page to load (title or product container)
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'pdp')]")),
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'pdp-product')]")),
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1"))
            ));

            // Scroll down a bit to load dynamic elements
            js.executeScript("window.scrollBy(0,300);");

            // 7. If size selection is required, select first available size
            try {
                // common size buttons container may use role/button or span
                List<WebElement> sizeOptions = wait.until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath(
                                "//div[contains(@class,'size-buttons') or contains(@class,'sizes')]" +
                                        "//button[not(contains(@class,'unavailable'))]" +
                                        "|//ul[contains(@class,'size-buttons')]//li[not(contains(@class,'disabled'))]" +
                                        "|//div[contains(@class,'size-list')]//button[not(contains(@class,'disabled'))]")));
                if (!sizeOptions.isEmpty()) {
                    WebElement firstSize = sizeOptions.get(0);
                    try {
                        wait.until(ExpectedConditions.elementToBeClickable(firstSize)).click();
                        System.out.println("Selected first available size.");
                    } catch (Exception e) {
                        // sometimes clickable fails — use JS
                        js.executeScript("arguments[0].click();", firstSize);
                        System.out.println("Selected size via JS click.");
                    }
                }
            } catch (Exception e) {
                // size selection not required or different DOM - continue
                System.out.println("No explicit size selection detected (or selection failed). Proceeding.");
            }

            // 8. Click Add to Bag — try multiple locator variants and retries
            boolean added = false;
            String[] addToBagXPaths = new String[]{
                    "//button[contains(text(),'ADD TO BAG') or contains(text(),'Add to Bag') or contains(.,'ADD TO BAG')]",
                    "//button[contains(text(),'ADD TO CART') or contains(text(),'Add to Cart')]",
                    "//div[contains(@class,'pdp-add-to-bag')]//button",
                    "//button[@data-testid='add-to-bag' or @data-testid='addToBag']",
                    "//button[contains(@class,'add-to-bag') or contains(@class,'addToCart')]"
            };

            for (String xpath : addToBagXPaths) {
                try {
                    WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                    // scroll into view before clicking
                    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", addBtn);
                    try {
                        addBtn.click();
                    } catch (Exception clickEx) {
                        js.executeScript("arguments[0].click();", addBtn);
                    }
                    // optionally wait a little for cart update
                    wait.until(ExpectedConditions.or(
                            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'cart-count') or contains(@class,'bag-count')]")),
                            ExpectedConditions.urlContains("cart"),
                            ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'added to bag') or contains(text(),'Added to bag') or contains(text(),'added to cart')]"))
                    ));
                    System.out.println("Clicked Add to Bag using xpath: " + xpath);
                    added = true;
                    break;
                } catch (Exception e) {
                    // try next xpath
                    System.out.println("AddToBag xpath failed: " + xpath);
                }
            }

            if (!added) {
                System.out.println("Could not find or click Add to Bag button. You may need to update locators for the current page DOM.");
            } else {
                System.out.println("Product added to bag (or add action triggered).");
            }

        } finally {
            // cleanup - uncomment when you want the browser to close automatically
            // driver.quit();
        }
    }
}
