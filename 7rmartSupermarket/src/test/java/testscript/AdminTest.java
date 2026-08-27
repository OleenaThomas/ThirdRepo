package testscript;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends Base{

	HomePage homepage;
	AdminPage adminpage;
	@Test(retryAnalyzer=retry.RetryClass.class, groups= {"regression"}, description="creates new admin")
	public void verifyNewAdminIsCreated() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username)
		.enterPassword(password);
		homepage=loginpage.clickLoginButton();
		
		//String adminusername=ExcelUtility.getStringData(1, 0, "adminpage");
		//String adminpassword=ExcelUtility.getStringData(1, 1, "adminpage");
		FakerUtility fakerutility=new FakerUtility();
		String adminusername=fakerutility.creatARandomFirstName();
		String adminpassword=fakerutility.creatARandomLastName();
		//No need of multiple driver passing, so the below
		//LOC is commented out as adminpage object is declared
		//globally.
		//AdminPage adminpage=new AdminPage(driver);
		//adminpage.createAdmin(adminusername, adminpassword);
		adminpage=homepage.clickAdminMoreInfo();
		// method chaining
		adminpage.clickAdminNewButton()
		.enterAdminUsername(adminusername)
		.enterAdminPassword(adminpassword)
		.selectUserType()
		.clickCreateAdminButton();
		/*
		 * adminpage.enterAdminUsername(adminusername);
		 
		adminpage.enterAdminPassword(adminpassword);
		adminpage.selectUserType();
		adminpage.clickCreateAdminButton();
		*/
		
		boolean newadmin=adminpage.isNewAdminDisplayed();
		Assert.assertTrue(newadmin);
	}
}
