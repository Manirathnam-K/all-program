package com.PageObjectModule;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PageObjectManager.PageObjectManager;
import com.base.Base_class;
import com.interfaceelements.LoginPageEnterfaceElements;

public class LoginPage extends Base_class implements LoginPageEnterfaceElements{

	@FindBy(linkText = login_LinkText)
	private WebElement login;
	
	@FindBy(id = userName_id)
	private WebElement username;
	
	@FindBy(css = password_css)
	private WebElement password;
	
	@FindBy(xpath = signin_xpath)
	private WebElement sigin;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void validLogin() throws IOException, InterruptedException {
		elementClick(login);
		inputValueElement(username,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("username"));
		inputValueElement(password,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
		elementClick(sigin);
	}
}