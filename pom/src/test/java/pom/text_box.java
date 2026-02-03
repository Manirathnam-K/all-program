package pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class text_box {
	
	static WebDriver driver;
	@Test
    public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximum");
		
		driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/text-box");
       // driver.manage().window().maximize();
        
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.enterUserName("mani");
        assertEquals(textBoxPage.userName.getAttribute("value"), "mani", "Username input value mismatch");
        textBoxPage.enterUserEmail("mani@gmail.com");
        driver.findElement(By.xpath("//div[@class=\"mt-2 justify-content-end row\"]//button")).click();
        
        // Optionally, add driver.quit() to close the browser after test
         driver.quit();
    }
}