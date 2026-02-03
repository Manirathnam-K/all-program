package Amazon_window.Amazon_window;

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

public class Windowhandles {
	WebDriver driver;
	@BeforeSuite
	public void launch(){
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String url = driver.getCurrentUrl();
		driver.getTitle();
		System.out.println(driver.getCurrentUrl());
	}
	
	@BeforeClass
	public void searchproduct() {
		WebElement Searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		Searchbox.sendKeys("mobiles",Keys.ENTER);
	}
	@Test(priority=1)
	public void firstproduct() {
		List<WebElement> products = driver.findElements(By.className("a-price-whole"));
		for (WebElement product : products) {
			System.out.println(product.getText());
			System.out.println(product.getSize());
			//System.out.println(products.replaceAll(",", ""));
			}
		}
	@AfterSuite
	public void teardown() {
        driver.quit();
    }
	}
	
	