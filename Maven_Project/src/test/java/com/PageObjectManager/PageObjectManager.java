package com.PageObjectManager;


import com.PageObjectModule.Cartpage;
import com.PageObjectModule.LoginPage;
import com.PageObjectModule.Logout;
import com.PageObjectModule.SearchProductPage;
//import com.PageObjectModule.Logout;
import com.utility.FileReaderManager;

public class PageObjectManager {

	private FileReaderManager fileReader;
	private static PageObjectManager pageObjectManager;
	private LoginPage loginpage;
	private Logout logoutpage;
	private Cartpage Cartpage;
	private SearchProductPage SearchProductPage;
	
	public FileReaderManager getFileReader() {
		if (fileReader == null)
			fileReader = new FileReaderManager();
		return fileReader;
	}
	
	public static PageObjectManager getPageObjectManager() {
		if (pageObjectManager == null) {
			pageObjectManager = new PageObjectManager();
		}
		return pageObjectManager;
	}
	
	public LoginPage getLoginpage() {
		if (loginpage == null) {
			loginpage = new LoginPage();
		}
		return loginpage;
	}
	
	public SearchProductPage getSearchProductPage(){
		if(SearchProductPage == null) {
			SearchProductPage = new SearchProductPage();
		}
			return SearchProductPage;
		}
	public Cartpage getCartpage(){
		if(Cartpage == null) {
			Cartpage = new Cartpage();
		}
			return Cartpage;
		}

	public Logout getLogoutpage() {
		if (logoutpage == null)
			logoutpage = new Logout();
		return logoutpage;
	}
}