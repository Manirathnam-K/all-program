package Page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoSauce_SignInPage {
	
	protected WebDriver driver;
	
	private By usernameBy = By.id("user-name");
	private By passwordBy = By.id("password");
	private By signinBy = By.id("login-button");
	
	//private String expectedTitle = "Swag Labs";
	
	public DemoSauce_SignInPage(WebDriver driver) {
		this.driver = driver;
		if(!driver.getTitle().equals("Swag Labs")) {
			throw new IllegalStateException("This is not Sign In Page,"+" current page is: "+driver.getCurrentUrl());
		}
	}

	public void loginValidUser(String userName, String password) {
		driver.findElement(usernameBy).sendKeys(userName);
		driver.findElement(passwordBy).sendKeys(password);
		driver.findElement(signinBy).click();
	}
  
}
