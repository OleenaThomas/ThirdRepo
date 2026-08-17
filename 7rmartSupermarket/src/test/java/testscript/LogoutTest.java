package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base{
	
	@Test(groups= {"regression"})
	public void verifyUserCanLogout() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		LogoutPage logoutpage=new LogoutPage(driver);
		logoutpage.logout();
		String expectedTitle="Login | 7rmart supermarket";
		String actualtitle=logoutpage.isLoginPage();
		AssertJUnit.assertEquals(actualtitle, expectedTitle);
	}
}
