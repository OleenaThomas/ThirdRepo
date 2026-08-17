package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{

	@Test(priority=1,groups= {"regression"})
	public void verifyUserCanLogin() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		boolean homepage=loginpage.isDashboardDisplayed();
		AssertJUnit.assertTrue(homepage);
	}
	
	@Test(priority=2)
	public void verifyUserDoesnotLoginWithIncorrectPassword() throws IOException {
		String username=ExcelUtility.getStringData(2, 0, "loginpage");
		String password=ExcelUtility.getStringData(2, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		boolean alert=loginpage.isAlertMessageDisplayed();
		AssertJUnit.assertTrue(alert);
	}
	
	@Test(priority=3)
	public void verifyUserDoesnotLoginWithIncorrectUsername() throws IOException {
		String username=ExcelUtility.getStringData(3, 0, "loginpage");
		String password=ExcelUtility.getStringData(3, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		boolean alert=loginpage.isAlertMessageDisplayed();
		AssertJUnit.assertTrue(alert);
	}

	@Test(priority=4)
	public void verifyUserDoesnotLoginWithInvalidCredentials() throws IOException {
		String username=ExcelUtility.getStringData(4, 0, "loginpage");
		String password=ExcelUtility.getStringData(4, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		boolean alert=loginpage.isAlertMessageDisplayed();
		AssertJUnit.assertTrue(alert);
	}
}
