package testscript;

import org.testng.annotations.Test;

import constant.Constant;

import org.testng.Assert;
import java.io.IOException;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{

	HomePage homepage;
	LoginPage loginpage;
	@Test(priority=1,groups= {"regression"}, description="user can login successfully with valid credentials")
	public void verifyUserCanLogin() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username)
		.enterPassword(password);
		// chaining of methods in the above line
		//loginpage.enterPassword(password);
		homepage=loginpage.clickLoginButton();
		boolean homepagedashboard=loginpage.isDashboardDisplayed();
		Assert.assertTrue(homepagedashboard,Constant.LOGINVALIDCREDENTIALS);
	}
	
	@Test(priority=2,description="user cannot login with incorrect password")
	public void verifyUserDoesnotLoginWithIncorrectPassword() throws IOException {
		String username=ExcelUtility.getStringData(2, 0, "loginpage");
		String password=ExcelUtility.getStringData(2, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		boolean alert=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert,Constant.LOGININVALIDPASSWORD);
	}
	
	@Test(priority=3,description="user cannot login with incorrect username")
	public void verifyUserDoesnotLoginWithIncorrectUsername() throws IOException {
		String username=ExcelUtility.getStringData(3, 0, "loginpage");
		String password=ExcelUtility.getStringData(3, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		boolean alert=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert, Constant.LOGININVALIDUSERNAME);
	}

	@Test(priority=4,description="user cannot login with invalid credentials")
	public void verifyUserDoesnotLoginWithInvalidCredentials() throws IOException {
		String username=ExcelUtility.getStringData(4, 0, "loginpage");
		String password=ExcelUtility.getStringData(4, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username)
		.enterPassword(password);
		// chaining of methods in the above line
		//loginpage.enterPassword(password);
		loginpage.clickLoginButton();
		boolean alert=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert, Constant.LOGININVALIDCREDENTIALS);
	}
}
