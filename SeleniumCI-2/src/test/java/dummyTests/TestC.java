package dummyTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestC {

  @BeforeClass
  public void beforeClass() {
	  System.out.println(">>>>>>>>testC BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println(">>>>>>>>testC AfterClass");
  }

  @BeforeTest
  public void beforeTest() { 
	  System.out.println(">>>>testC BeforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println(">>>>testC AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("testC BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("testC AfterSuite");
  }

}
