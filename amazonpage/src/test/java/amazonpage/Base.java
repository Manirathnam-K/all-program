package amazonpage;

import java.io.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	
	public static void initialization() {
		//System.setProperty("Webdriver.chrome.driver","/Users/Admin/Downloads/chromedriver-mac-arm64");
		WebDriver driver = new ChromeDriver();
		//driver = new ChromeDriver ();
		driver.get("https://www.google.com/");
	}
	
	public void failed() {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("/Users/Admin/eclipse-workspace/amazonpage/Screenshot/testFail.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}