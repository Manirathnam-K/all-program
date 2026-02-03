package com.Testng;

import org.testng.annotations.Test;

public class DependsOnMethod {
	@Test
	private void login() {
		System.out.println("Login Method");
	}

	@Test
	private void searchpage() {
		System.out.println("Search_page");
	}
	@Test
	private void addtoCartpage () {
		System.out.println("addtoCartpage");
	}
	@Test(dependsOnMethods= {"login","searchpage"})
	private void Search_Product() {
		System.out.println("Search_Product");
	}
	@Test
	private void logout() {
		System.out.println("Logout_method");
	}
	
	
}
