package com.Testng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.base.Base_class;

public class CrossbrowserTesting extends Base_class {
	
	@Test(enabled=false)
	private void safari() {
		LaunchBrowser("Safari");
		LaunchUrl("https://www.google.com/");
		System.out.println("Browser ID : " + Thread.currentThread().getId());
	}
	
	@Test
	private void chromeBrowser() {
		LaunchBrowser("chrome");
		LaunchUrl("https://www.google.com/");
		System.out.println("Browser ID : " + Thread.currentThread().getId());
	}
	@Test
	private void edge() {
		LaunchBrowser("edge");
		LaunchUrl("https://www.google.com/");
		System.out.println("Browser ID : " + Thread.currentThread().getId());
	}
	
}
