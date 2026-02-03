package com.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.ReadExcelData;

public class TestExcelscript {

public static void main(String[] args) throws InterruptedException  {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.youtube.com");
		
		String search =  ReadExcelData.readPrticularData(0,0);
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(search,Keys.ENTER);
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='search_query']")).clear();
		
		String search1 =  ReadExcelData.readPrticularData(1,1);
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(search1,Keys.ENTER);
		
//		String userName = ReadExcelData.readPrticularData(2,0);
//		
//		driver.findElement(By.id("email")).sendKeys(userName);
//		
//		String password = ReadExcelData.readPrticularData(2,1);
//		
//		driver.findElement(By.id("pass")).sendKeys(password);

		Thread.sleep(4000);
		driver.quit();
		
	}
}