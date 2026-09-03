package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

//this is a class copied from LogoutTest to demonstrate chaining

public class HomeTest extends Base{
	HomePage homepage;
	@Test(groups= {"regression"},description="user can successfully logout")
	public void verifyUserCanLogout() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username)
		.enterPassword(password);
		homepage=loginpage.clickLoginButton();
		
		LogoutPage logoutpage=new LogoutPage(driver);
		logoutpage.logout();
		String expectedTitle="Login | 7rmart supermarket";
		String actualtitle=logoutpage.isLoginPage();
		Assert.assertEquals(actualtitle, expectedTitle);
	}
}
