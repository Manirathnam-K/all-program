package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement {

	public static void scrollToAndClickElement(WebDriver driver, WebElement element) {
	    try {
	        // This will automatically scroll the element into view
	        new Actions(driver)
	            .moveToElement(element)
	            .click()
	            .perform();
	    } catch (Exception e) {
	        // If standard approach fails, use JavaScript click
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
	        js.executeScript("arguments[0].click();", element);
	    }
	}
	public static void scrollToElement(WebDriver driver, WebElement element) {
	    try {
	        // This will automatically scroll the element into view
	        new Actions(driver)
	            .moveToElement(element)
	            .perform();
	    } catch (Exception e) {
	        // If standard approach fails, use JavaScript click
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
	    }
	}
}
