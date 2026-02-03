package com.PageObjectModule;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.Base_class;
import com.interfaceelements.KeySkillsInterfaceElements;

public class KeySkillsPage extends Base_class implements KeySkillsInterfaceElements{
//	@FindBy(linkText = login_LinkText)
//	private WebElement login;
//
//	@FindBy(linkText = login_LinkText)
//	private WebElement login;
//	
	@FindBy(xpath = keyskillEdit_xpath)
	private WebElement keyskillEdit;

	@FindBy(xpath = skills_xpath)
	private WebElement skills;
	
	@FindBy(id = save_id)
	private WebElement save;

	public KeySkillsPage() {
		PageFactory.initElements(driver, this);
	}

	public void KeySkillsPage() throws IOException, InterruptedException {
		
		//inputValueElement(email,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("email"));
		//inputValueElement(password,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
		Thread.sleep(3000);		
		elementClick(keyskillEdit);
		elementClick(skills);
		elementClick(save);
	}
}
