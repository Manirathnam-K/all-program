package com.PageObjectModule;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_class;

public class Logout extends Base_class implements com.interfaceelements.LogoutInterfaceElements {
	
	@FindBy(id = "logout2")
	private WebElement logout;
	
	public Logout() {
		PageFactory.initElements(driver, this);	}

	public void validlogout() throws IOException, InterruptedException{
		
		elementClick(logout);
		
		
	}

}