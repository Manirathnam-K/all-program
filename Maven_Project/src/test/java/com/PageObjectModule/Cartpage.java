package com.PageObjectModule;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PageObjectManager.PageObjectManager;
import com.base.Base_class;
import com.interfaceelements.CartInterfaceElements;

public class Cartpage extends Base_class implements CartInterfaceElements{ 
	
	@FindBy(linkText = cart_linkText)
	private WebElement cart;
	
	@FindBy(xpath = placeOrder_xpath)
	private WebElement placeOrder;
	
	@FindBy(id = name_id)
	private WebElement id;
	
	@FindBy(id = country_id)
	private WebElement country;
	
	@FindBy(id = city_id)
	private WebElement city;
	
	@FindBy(id = creditCard_id)
	private WebElement card;
	
	@FindBy(id = month_id)
	private WebElement month;
	
	@FindBy(id = year_id)
	private WebElement year;
	
	@FindBy(xpath = purchase_xpath)
	private WebElement purchase;
	
	@FindBy(xpath = ok_xpath)
	private WebElement ok;
	
	public Cartpage() {
		PageFactory.initElements(driver, this);
	}

	public void validCartpage() throws InterruptedException, IOException {
	elementClick(cart);
	elementClick(placeOrder);		
	inputValueElement(year,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("year"));
	inputValueElement(id,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("name"));
	inputValueElement(country,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("country"));
	inputValueElement(city,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("city"));
	inputValueElement(card,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("card"));
	inputValueElement(month,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("month"));
	elementClick(purchase);
	Thread.sleep(2000);
	elementClick(ok);
}
}