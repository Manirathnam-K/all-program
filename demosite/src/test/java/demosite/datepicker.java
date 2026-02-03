package demosite;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class datepicker {
	WebDriver driver = null; // ✅ Make driver global
	
@BeforeSuite
public void navigation() {
	driver = new ChromeDriver();
	driver.get("https://demo.automationtesting.in/Datepicker.html");
	driver.manage().window().maximize();
	String d =driver.getTitle();
}	
@Test(priority = 1)
public void datepick() {
	Boolean picker = driver.findElement(By.className("imgdp")).isDisplayed();
	System.out.println(driver.getTitle());
	if(picker)
	{
		driver.findElement(By.className("imgdp")).click();
		driver.findElement(By.xpath("//a[normalize-space(text())='15']")).click();
		System.out.println(driver.getTitle());
		  LocalDate today = LocalDate.now();
	        LocalDate futureDate = today.plusDays(1);

	        int day = futureDate.getDayOfMonth();
	        int month = futureDate.getMonthValue();
	        int year = futureDate.getYear();
	        System.out.println("Future Date: " + day + "/" + month + "/" + year);
	}
	else
	{
		System.out.println("Datepicker not found");
	}
}
@Test(priority = 2)
public void datepickEnable() throws InterruptedException {
driver.findElement(By.id("datepicker2")).sendKeys("09/18/1994");
driver.findElement(By.className("datepick-cmd datepick-cmd-close")).click();
		}

@AfterSuite
public void close() throws IOException {
    // Ensure Screenshot directory exists
    File screenshotDir = new File("/Users/Admin/eclipse-workspace/demosite/Screenshot");
    if (!screenshotDir.exists()) {
        screenshotDir.mkdirs();
    }
    // Save screenshot as screenshot.png
    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    File destFile = new File(screenshotDir, "screenshot.png");
    FileUtils.copyFile(screenshot, destFile);
    System.out.println("Screenshot taken: " + destFile.getAbsolutePath());
    if(driver != null)
    {
        driver.quit();
    }
}
}