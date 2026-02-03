package com.Testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class simpleAnnotations {
	
	@BeforeSuite
	private void propertySetting() {
		System.out.println("propertySetting");
	}
	
	@BeforeTest
	private void browserURL() {
		System.out.println("browserURL");
	}
	@BeforeClass
	private void URLLaunch() {
		System.out.println("urlLaunch");
	}
	@BeforeMethod
	private void login() {
		System.out.println("login");
	}
	@Test	
	private void woman() {
		System.out.println("Woman");
	}
	@Test
	private void kids() {
		System.out.println("Kids");
	}
	@Test
	private void mens() {
		System.out.println("Mens");
	}
	@AfterMethod
	private void logout() {
		System.out.println("logout");
	}
	@AfterClass
	private void screenshot() {
		System.out.println("Screenshot");
	}
	@AfterTest
	private void close() {  
		System.out.println("close");
	}
	@AfterSuite
	private void terminatebroswer() {
		System.out.println("Terminatebrowser");
	}

}
