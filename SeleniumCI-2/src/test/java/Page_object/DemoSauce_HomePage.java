package Page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoSauce_HomePage {

	protected WebDriver driver;
	
	By burgerButton = By.id("react-burger-menu-btn");
	
	public DemoSauce_HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement checkMenuButton() {
		return driver.findElement(burgerButton);
	}
}
