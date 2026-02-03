package TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Page_object.DemoSauce_SignInPage;
import Page_object.DemoSauce_HomePage;


public class DemoSauceSite {
	WebDriver driver;
	DemoSauce_SignInPage signInPage;
	DemoSauce_HomePage homePage;
	
	
  @Test(groups = {"smoke"})
  public void testLogin() {
	  signInPage = new DemoSauce_SignInPage(driver);
	  System.out.println("running smoke test");
	  signInPage.loginValidUser("standard_user", "secret_sauce");
	  homePage = new DemoSauce_HomePage(driver);
	  Assert.assertNotNull(homePage.checkMenuButton().isDisplayed() , "Menu button not displayed");
  }
  

  @BeforeClass(groups= {"setup"})
  public void beforeClass() {
	  driver = new ChromeDriver();
	  driver.get("https://www.saucedemo.com/");
	  System.out.println("1111111111111111111");
  }

  @AfterClass(groups= {"setup"})
  public void afterClass() {
	  driver.quit();
  }


}
