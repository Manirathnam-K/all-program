package TestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoSauceSite2 {
	
  @Test(groups = {"negative"})
  public void validUser() {
	 System.out.println("Running Negative test case");
  }
  
  @Test(groups={"positive"})
  public void smokeRunner() {
	System.out.println("Runing Smoke Test");  
  }
  
	@BeforeTest
	public void beforeTest() {
		System.out.println("running before positive");
	}

}
