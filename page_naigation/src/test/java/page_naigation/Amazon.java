package page_naigation;

import java.awt.Component;
import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {
	
	static WebDriver driver = null;
	static ChromeOptions options = null;
	
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get("https://www.amazon.co.in");
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}catch(Exception e)
		{
		System.out.println(driver.getTitle());
		}
		WebElement searchBox =driver.findElement(By.xpath("//input[@placeholder=\"Search Amazon.in\"]"));
		searchBox.sendKeys("water heater",Keys.RETURN);
		
		WebElement product = driver.findElement(By.xpath("//div[@data-index='3']/following::span[@class='a-price-whole']"));
		//System.out.println(product);
		product.click();
		
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		String p =it.next();
		String c= it.next();
		
		driver.switchTo().window(c);
		
		driver.switchTo().window(p);
		driver.getTitle();
		
		
				
		//driver.quit();
	}

}
