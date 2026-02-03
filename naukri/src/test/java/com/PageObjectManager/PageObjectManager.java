package com.PageObjectManager;


import com.PageObjectModule.CareerProfilePage;
import com.PageObjectModule.EducationPage;
import com.PageObjectModule.EmployeementPage;
import com.PageObjectModule.ITSkillsPage;
import com.PageObjectModule.KeySkillsPage;
import com.PageObjectModule.LoginPage;
import com.PageObjectModule.LogoutPage;
import com.PageObjectModule.PersonalPage;
import com.PageObjectModule.ProfielSummaryPage;
import com.PageObjectModule.ProfileUpdate;
import com.PageObjectModule.ProjectsPage;
import com.PageObjectModule.ResumeHeadLinePage;
import com.PageObjectModule.ResumeUploadPage;
//import com.PageObjectModule.Logout;
import com.utility.FileReaderManager;

public class PageObjectManager {

	private FileReaderManager fileReader;
	private static PageObjectManager pageObjectManager;
	private LoginPage loginpage;
	private ProfileUpdate ProfileUpdate;
	private ResumeUploadPage ResumeUploadPage;
	private ResumeHeadLinePage ResumeHeadLinePage;
	private ProjectsPage ProjectsPage;
	private ProfielSummaryPage ProfielSummaryPage;
	private PersonalPage PersonalPage;
	private LogoutPage LogoutPage;
	private KeySkillsPage KeySkillsPage;
	private ITSkillsPage ITSkillsPage;
	private EmployeementPage EmployeementPage;
	private EducationPage EducationPage;
	private CareerProfilePage CareerProfilePage;

	//private Logout logoutpage;
	//private Cartpage Cartpage;
	//private SearchProductPage SearchProductPage;

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

	public ProfileUpdate getProfileUpdate(){
		if(ProfileUpdate == null) {
			ProfileUpdate = new ProfileUpdate();
		}
		return ProfileUpdate;
	}
	public ResumeUploadPage getResumeUploadPage(){
		if(ResumeUploadPage == null) {
			ResumeUploadPage = new ResumeUploadPage();
		}
		return ResumeUploadPage;
	}

	public ResumeHeadLinePage getResumeHeadLinePage() {
		if (ResumeHeadLinePage == null) {
			ResumeHeadLinePage = new ResumeHeadLinePage();
		}
		return ResumeHeadLinePage;
	}

	public ProfielSummaryPage getProfielSummaryPage(){
		if(ProfielSummaryPage == null) {
			ProfielSummaryPage = new ProfielSummaryPage();
		}
		return ProfielSummaryPage;
	}

	public PersonalPage getPersonalPage(){
		if(PersonalPage == null) {
			PersonalPage = new PersonalPage();
		}
		return PersonalPage;
	}

	public KeySkillsPage getKeySkillsPage(){
		if(KeySkillsPage == null) {
			KeySkillsPage = new KeySkillsPage();
		}
		return KeySkillsPage;
	}


	public ITSkillsPage getITSkillsPage(){
		if(ITSkillsPage == null) {
			ITSkillsPage = new ITSkillsPage();
		}
		return ITSkillsPage;
	}

	public EmployeementPage getEmployeementPage(){
		if(EmployeementPage == null) {
			EmployeementPage = new EmployeementPage();
		}
		return EmployeementPage;
	}


	public EducationPage getEducationPage(){
		if(EducationPage == null) {
			EducationPage = new EducationPage();
		}
		return EducationPage;
	}

	public CareerProfilePage getCareerProfilePage(){
		if(CareerProfilePage == null) {
			CareerProfilePage = new CareerProfilePage();
		}
		return CareerProfilePage;
	}


	public LogoutPage getLogoutPage() {
		if (LogoutPage == null)
			LogoutPage = new LogoutPage();
	
	return LogoutPage;
}
}


