package com.PageObjectModule;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.Base_class;
import com.PageObjectManager.PageObjectManager;
import com.interfaceelements.ProfileUpdateInterfaceElemets;

public class ProfileUpdate extends Base_class implements ProfileUpdateInterfaceElemets {

//	@FindBy(linkText = login_LinkText)
//	private WebElement login;
	
	
			
// @FindBy(className = chatbot_class)
//	private WebElement chatbot;		
//	
	@FindBy(className = profileIcon_class)
	private WebElement profileIcon ;
	
	@FindBy(xpath = updateprofile_xpath)
	private WebElement updateprofile ;
	
	public ProfileUpdate() {
		PageFactory.initElements(driver, this);
	}

	public void ProfileUpdate()  {
		
		//inputValueElement(email,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("email"));
		//inputValueElement(password,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
	//	elementClick(chatbot);
		elementClick(profileIcon);
		elementClick(updateprofile);
	}
}



//public LoginPage() {
//	PageFactory.initElements(driver, this);
//}
//
//public void validLogin() throws IOException, InterruptedException {
//	
//	inputValueElement(email,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("email"));
//	inputValueElement(password,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
//	elementClick(login);
//}
//}