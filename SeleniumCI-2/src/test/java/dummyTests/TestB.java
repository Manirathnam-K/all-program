package dummyTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestB {
  @Test
  public void test3ofTestB() {
	  System.out.println(">>>>>>>>>>>>>>>>test3");
  }
  @Test
  public void test4ofTestB() {
	  System.out.println(">>>>>>>>>>>>>>>>test4");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println(">>>>>>>>>>>>testB BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println(">>>>>>>>>>>>testB AfterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println(">>>>>>>>testB BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println(">>>>>>>>testB AfterClass");
  }

}
