package com.Testng;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import com.base.Base_class;

	
	public class Invocationcount extends Base_class {
		
		@Test(invocationCount=100)
		private void invocation() {
			WebDriver driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.com/");
			driver.quit();
			//System.out.println("Invocation Count Example");
		}
	}

