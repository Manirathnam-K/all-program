package com.Testng;

import org.testng.annotations.Test;

public class PriorityClass {
	@Test(priority=-1)
	private void login() {
		System.out.println("Login Method");
	}

	@Test(priority=-4)
	private void searchpage() {
		System.out.println("Search_page");
	}
	@Test(priority=8)
	private void addtoCartpage () {
		System.out.println("addtoCartpage");
	}
	@Test(priority=23)
	private void Search_Product() {
		System.out.println("Search_Product");
	}
	@Test(priority=(15))
	private void logout() {
		System.out.println("Logout_method");
	}
	
	
}
