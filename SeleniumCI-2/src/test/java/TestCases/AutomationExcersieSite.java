package TestCases;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationExcersieSite {
	
	private WebDriver driver;
	
	  @Test
	  public void printAllCategory() {
	  //click on last category available
		  List<WebElement> category = driver.findElements(By.cssSelector(".panel-title > a"));
		  for (Iterator iterator = category.iterator(); iterator.hasNext();) {
			  WebElement webElement = (WebElement) iterator.next();
			  System.out.println(webElement.getText());
		}
	  }
		
	  @Test
	  public void tapLastCategory() {
		  WebElement category = driver.findElement(By.cssSelector(".panel-title a:last-child"));
		  System.out.println(">clicking on >"+category.getText());
		  //category.click();
	  }

	  @Test
	  public void tapSecondCategory() {
		  WebElement category = driver.findElement(By.cssSelector(".panel-title a::nth-of-type(2)"));
		  System.out.println(">clicking on >"+category.getText());
		  //category.click();
	  }

	@BeforeClass
	public void beforeClass(){
		driver = new ChromeDriver();
		driver.get("https://www.automationexercise.com/");
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
