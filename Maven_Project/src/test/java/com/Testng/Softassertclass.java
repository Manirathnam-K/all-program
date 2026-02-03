package com.Testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Base_class;

public class Softassertclass extends Base_class {
	
	@Test
	private void softassertion() {
		String actual="Firstname";
		String expected="Lastname";
		
		SoftAssert soft =new SoftAssert();
		soft.assertEquals(actual, expected);
		System.out.println("Verification Done");
		
	}

}
