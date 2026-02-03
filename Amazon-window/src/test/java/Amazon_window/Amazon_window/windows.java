package Amazon_window.Amazon_window;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class windows {
	WebDriver driver;
	@BeforeSuite
	public void launchurl() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String  url = driver.getCurrentUrl();
		System.out.println(url);
	}
	@BeforeClass
	public void searchbox() {
		WebElement Searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		Searchbox.sendKeys("mobile",Keys.ENTER);
	}
	
	@Test(priority=1)
	public void FirstProduct() {
		driver.findElement(By.xpath("(//div[@class='puisg-col-inner'])[1]")).click();
	}
	@Test(priority=2)
	public void windows() {
		List<String> list = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("(//input[@title=\"Add to Shopping Cart\"])[1]")).click();
		driver.switchTo().window(list.get(0));
	}
	@AfterSuite
	public void teardown() {
		driver.quit();
	}
	}

