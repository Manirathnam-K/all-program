package dummyTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestA {
  @Test
  public void test1ofTestA() {
	  System.out.println(">>>>>>>>>>>>>>>>test1");
  }
  @Test
  public void test2ofTestA() {
	  System.out.println(">>>>>>>>>>>>>>>>test2");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println(">>>>>>>>>>>>testA BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println(">>>>>>>>>>>>testA AfterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println(">>>>>>>>testA BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println(">>>>>>>>testA AfterClass");
  }

}
