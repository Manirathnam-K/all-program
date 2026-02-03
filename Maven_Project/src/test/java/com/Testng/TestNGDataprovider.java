package com.Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataprovider {
	@DataProvider(name = "ExcelDataProvider")
		public Object[][] dataProviderMethod() {
		String filepath = System.getProperty("user.dir")+"//Excelfile//Testdata.xlsx"; 
			String sheetName = "data";
			return ExcelUtility.getExcelData(filepath, sheetName);	
	}
	@Test(dataProvider = "ExcelDataProvider")
	public void login(String username, String password) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.quit();
    }
}