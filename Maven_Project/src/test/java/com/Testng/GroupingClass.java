package com.Testng;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class GroupingClass {
	@Test(groups="sanity")
	private void dosa() {
		System.out.println("dosa");
	}
	@Test(groups="sanity")
	private void pori() {
		System.out.println("pori");
	}
	@Test(groups="regression")
	private void rice() {
		System.out.println("rice");
	}
	@Test(groups="sanity")		
	private void Milk() {
		System.out.println("Milk");
	}
	@Test(groups="smoke")
	private void apple() {
		System.out.println("apple");
	}
	@Test(groups="smoke")
	private void Mango() {
		System.out.println("mango");
	}
	@Test(groups="smoke")
	private void orange() {
		System.out.println("orange");
	}
	@Test(groups="smoke")
	private void watermelon() {
		System.out.println("Watermelon");
	}

}
