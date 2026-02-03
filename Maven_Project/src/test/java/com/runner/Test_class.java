package com.runner;

import java.io.IOException;

import com.PageObjectManager.PageObjectManager;
import com.base.Base_class;

public class Test_class extends Base_class {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		LaunchBrowser(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
		LaunchUrl(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("Url"));	
		PageObjectManager.getPageObjectManager().getLoginpage().validLogin();	
		PageObjectManager.getPageObjectManager().getSearchProductPage().validSearchProductPage();
		PageObjectManager.getPageObjectManager().getCartpage().validCartpage();
		PageObjectManager.getPageObjectManager().getLogoutpage().validlogout();
		System.out.println("Test Case Passed");
		quitBrowser();
	}
}