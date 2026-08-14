package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base{
	
	@Test
	public void verifyUserCanLogout() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		LogoutPage logoutpage=new LogoutPage(driver);
		logoutpage.logout();
		String expectedTitle="Login | 7rmart supermarket";
		String actualtitle=logoutpage.isLoginPage();
		Assert.assertEquals(actualtitle, expectedTitle);
	}
}
