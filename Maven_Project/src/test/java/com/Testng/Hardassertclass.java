package com.Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.Base_class;

public class Hardassertclass extends Base_class {
	@Test
	private void softassertion() {
		String actual="Firstname";
		String expected="Lastname";
		
		Assert.assertEquals(actual, expected);
		System.out.println("validation Done");
		
	}
}
