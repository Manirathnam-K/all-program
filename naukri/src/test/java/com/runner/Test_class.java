package com.runner;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Base.Base_class;
import com.PageObjectManager.PageObjectManager;

public class Test_class extends Base_class {

	
	
	@BeforeSuite	
	public void launch()throws IOException  {
	LaunchBrowser(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
	LaunchUrl(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("Url"));	
	}
	
	@Test(priority = 1)
	public void validLogin() throws IOException, InterruptedException {
		PageObjectManager.getPageObjectManager().getLoginpage().validLogin();
	}
	
	@Test(priority = 2)
	public void profileUpdate() throws IOException  {
	PageObjectManager.getPageObjectManager().getProfileUpdate().ProfileUpdate();
	}
	
	@Test(priority = 3)
	public void ResumeHeadLinePage() throws IOException, InterruptedException  {
	PageObjectManager.getPageObjectManager().getResumeHeadLinePage().ResumeHeadLinePage();
	}
	
	@Test(priority = 4)
	public void KeySkillsPage() throws IOException, InterruptedException  {
	PageObjectManager.getPageObjectManager().getKeySkillsPage().KeySkillsPage();
	}
	
	@Test(priority = 5)
	public void EmployeementPage() throws IOException, InterruptedException {
		PageObjectManager.getPageObjectManager().getEmployeementPage().EmployeementPage();
	}
	

//		PageObjectManager.getPageObjectManager().getSearchProductPage().validSearchProductPage();
//		PageObjectManager.getPageObjectManager().getCartpage().validCartpage();
//		PageObjectManager.getPageObjectManager().getLogoutpage().validlogout();
	@AfterSuite
	public void logoutPage()throws IOException  {
		System.out.println("Test Case Passed");
		quitBrowser();

}
}


