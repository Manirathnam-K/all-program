package page_naigation;

import java.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



public class windowhandles {




	    public static void main(String[] args) throws Exception {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // 1. Open Myntra
	        driver.get("https://www.myntra.com/");

	        // 2. Search s24
	        driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"))
	                .sendKeys("s24", Keys.ENTER);

	        Thread.sleep(2000);

	        // 3. Click first product
	        WebElement firstProduct = driver.findElement(By.xpath("(//li[contains(@class,'product-base')])[1]//a"));
	        firstProduct.click();

	        // 4. Switch to new tab
	        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
	        driver.switchTo().window(tabs.get(1));

	        Thread.sleep(3000);

	        // 5. Click Add to Bag
	        driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();

	        System.out.println("Added to cart successfully!");
	        
	        //6. moving to cart
	        driver.findElement(By.xpath("//a[@class='desktop-cart']")).sendKeys(Keys.ENTER);
	        
	        //7.Remove the product from cart
	        driver.findElement(By.className("itemContainer-base-closeIcon")).click();
	        driver.findElement(By.xpath("(//button[text()='REMOVE'])[2]")).click();
	        System.out.println("Removed from cart successfully!");
	        driver.close();
	        
	        driver.switchTo().window(tabs.get(0));
            System.out.println("Product opened in same tab.");
            try {
            driver.quit();
            
            System.out.println("browser closed");
            }
            finally
            {
            	System.out.println("browser not closed");
            
            }
	    }
	}
