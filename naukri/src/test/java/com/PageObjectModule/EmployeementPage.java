package com.PageObjectModule;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.Base_class;
import com.PageObjectManager.PageObjectManager;
import com.interfaceelements.EmployeementInterfaceElements;

public class EmployeementPage extends Base_class implements EmployeementInterfaceElements {
	
	@FindBy(xpath = addemployment_xpath)
	private WebElement addemployment;

	@FindBy(css = companyname_css)
	private WebElement companyname;

	@FindBy(css = designation_css)
	private WebElement designation;

	@FindBy(css = joinedyear_css)
	private WebElement joinedyear;

	@FindBy(css = joinedmonth_css)
	private WebElement joinedmonth;

	@FindBy(css = skillused_css)
	private WebElement skillused;

	@FindBy(css = noticeperiod_css)
	private WebElement noticeperiod;

	@FindBy(css = save_css)
	private WebElement save;

	
	public EmployeementPage() {
		PageFactory.initElements(driver, this);
	}

	public void EmployeementPage() throws IOException, InterruptedException {
		Thread.sleep(3000);
		elementClick(addemployment);
		inputValueElement(companyname,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("companyname"));
		inputValueElement(designation,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("designation"));
		inputValueElement(joinedyear,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("joinedyear"));
		inputValueElement(joinedmonth,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("joinedmonth"));
		inputValueElement(skillused,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("skillused"));
		inputValueElement(noticeperiod,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("noticeperiod"));
		elementClick(save);
	}
}