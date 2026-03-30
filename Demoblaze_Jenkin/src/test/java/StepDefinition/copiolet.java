package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class copiolet {

    public static WebDriver driver;
    
    

@Given("User as to launch the chrome browser")
public void user_as_to_launch_the_chrome_browser() {
	driver = new ChromeDriver();
    
}

@When("User opens the URL")
public void user_opens_the_url() {
    	driver.get("https://www.demoblaze.com/index.html");
    	String title = driver.getTitle();
		System.out.println("Page Title: " + title);

    }

    @Then("wait till the product was dispaly")
    public void wait_till_the_product_was_dispaly() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
    }

    @Then("add to cart")
    public void add_to_cart() {
    	WebElement copilot = driver.findElement(By.xpath("//a[contains(text(),'Samsung galaxy s6')]"));
		copilot.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("name")));
        
    }

    @Then("Accept the popup")
    public void accept_the_popup() {
    	driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
        
    }

    @When("product added in the cart click on the cart icon")
    public void product_added_in_the_cart_click_on_the_cart_icon() {
    	driver.findElement(By.id("cartur")).click();
    	driver.close();
    	driver.quit();
    
    }
}