package com.PageObjectModule;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.Base_class;
import com.PageObjectManager.PageObjectManager;
import com.interfaceelements.ResumeHeadLineInterfaceElements;

public class ResumeHeadLinePage extends Base_class implements ResumeHeadLineInterfaceElements {
	
	
		
		@FindBy(xpath = ResumeHeadLinePage_xpath)
		private WebElement addresume;
		
		@FindBy(id = resumeHeadlineTxt_id)
		private WebElement resumeHeadline;

		@FindBy(xpath = SaveButton_xpath)
		private WebElement SaveButton;
		
		public ResumeHeadLinePage() {
			PageFactory.initElements(driver, this);
		}
		
		public void ResumeHeadLinePage() throws IOException, InterruptedException {
			
			//inputValueElement(email,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("email"));
			//inputValueElement(password,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
			Thread.sleep(3000);
			elementClick(addresume);
			inputValueElement(resumeHeadline,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("resumeHeadline"));
			elementClick(SaveButton);
			
		}
	}
	

