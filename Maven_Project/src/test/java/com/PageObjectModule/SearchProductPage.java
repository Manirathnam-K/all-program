package com.PageObjectModule;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.PageObjectManager.PageObjectManager;
import com.base.Base_class;
import com.interfaceelements.SearchProductInterfaceElements;


public class SearchProductPage extends Base_class  implements SearchProductInterfaceElements{ 

	@FindBy(xpath = catagories_xpath)
	private WebElement catagories;
	
	@FindBy(linkText = product_linkText)
	private WebElement product;
	
	@FindBy(linkText = addToCart_linkText)
	private WebElement addToCart;
	
	public SearchProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validSearchProductPage() throws IOException, InterruptedException {
		Thread.sleep(2000);
		elementClick(catagories);
		elementClick(product);
		elementClick(addToCart);
		
	}
}