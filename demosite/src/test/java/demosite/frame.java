package demosite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*
;

public class frame {
	WebDriver driver = null; // ✅ Make driver global
	
@BeforeSuite
public void launch() {
	driver = new ChromeDriver();
	driver.get("https://demo.automationtesting.in/Frames.html");
	driver.manage().window().maximize();	

}
	@Test
public void singleframe() {
	driver.switchTo().frame(0);
	System.out.println(driver.getTitle());
}
@AfterSuite
public void close() {
if(driver != null)
{
	driver.quit();
}
}
}