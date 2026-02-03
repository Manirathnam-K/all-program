package dropdown;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class switchwindow {
	
	WebDriver driver;
	WebDriverWait wait;
	String str ;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.co.in/");
		JavascriptExecutor js = (JavascriptExecutor)driver;      
		js.executeScript("window.scrollBy(0,1000)");
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void searchAmazon() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
		driver.findElement(By.id("nav-search-submit-button")).click();
		str = driver.getTitle();
		System.out.println(str);
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));//Implicit wait
	}

	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}