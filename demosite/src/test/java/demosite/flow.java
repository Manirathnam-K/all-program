package demosite;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class flow {
	WebDriver driver = null; // ✅ Make driver global
	Alert alert = null;
	JavascriptExecutor js = (JavascriptExecutor)driver;      
	
    @BeforeSuite
    public void launch() {
        driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();
       
    }
    @Test(priority = 0)    
    public void navigateToAlertsPage() {
		driver.findElement(By.xpath("//a[normalize-space(text())='SwitchTo']")).click();
		driver.findElement(By.xpath("//a[normalize-space(text())='Alerts']")).click();
	}
	
    @Test(priority = 1)
    public void alertWithOK() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space(text())='Alert with OK']")).click();
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }

    @Test(priority = 2)
    public void alertWithOKCancel() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space(text())='Alert with OK & Cancel']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space(text())='Alert with OK & Cancel']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
    }
    
    @Test(priority = 3)
    public void alertWithTextbox() throws InterruptedException {

		
		driver.findElement(By.xpath("//a[normalize-space(text())='Alert with Textbox']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		//driver.switchTo().alert().sendKeys("Selenium");
		driver.switchTo().alert().accept();
    		
    }
    @Test(priority = 4)
    public void MultipleTabs() throws InterruptedException {
    	driver.get("https://demoqa.com/browser-windows");
    	driver.findElement(By.id("tabButton")).click();
    	
    	// Get the handle of the parent window	
    	String parent = driver.getWindowHandle(); 	
    	// Get the handles of all open windows
    	Set<String> allWindows = driver.getWindowHandles();
    	// Switch to each window and close it if it's not the parent
    	for (String window : allWindows) {
    	    if (!window.equals(parent)) {
    	        driver.switchTo().window(window);
    	        // Perform actions
    	        driver.close();
    	    }
    	}
    	driver.switchTo().window(parent);

    	
    }

    @AfterSuite
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
