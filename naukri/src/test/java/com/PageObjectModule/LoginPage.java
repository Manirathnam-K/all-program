package com.PageObjectModule;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.Base_class;
import com.PageObjectManager.PageObjectManager;
import com.interfaceelements.logininterfaceelement;

public class LoginPage extends Base_class implements logininterfaceelement{
	
//	@FindBy(linkText = login_LinkText)
//	private WebElement login;
//
//	@FindBy(linkText = login_LinkText)
//	private WebElement login;
//	
	@FindBy(id = email_id)
	private WebElement email;

	@FindBy(id = password_id)
	private WebElement password;
	
	@FindBy(xpath = login_xpath)
	private WebElement login;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void validLogin() throws IOException, InterruptedException {
		
		inputValueElement(email,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("email"));
		inputValueElement(password,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
		
		elementClick(login);
	}
}