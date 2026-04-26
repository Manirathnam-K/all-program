package stepdefinition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;

public class Webpage_site {
	public static WebDriver driver;
	
	@Given("User should {string} validate the given url was working find.")
	public void user_should_validate_the_given_url_was_working_find(String Link) {
		driver = new ChromeDriver();
		driver.get(Link);
		//page_loading time
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long loadTime = (Long) js.executeScript("return window.performance.timing.loadEventEnd - window.performance.timing.navigationStart;");

		System.out.println("Page Load Time: " + loadTime + " ms");
		System.out.println("Links = " + Link);
		
		driver.quit();
	}
	
   
}


