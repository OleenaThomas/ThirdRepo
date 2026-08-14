package testscript;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminTest extends Base{

	@Test
	public void verifyNewAdminIsCreated() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		String adminusername="admin112";
		String adminpassword="admin112";
		AdminPage adminpage=new AdminPage(driver);
		adminpage.createAdmin(adminusername, adminpassword);
		boolean newadmin=adminpage.isNewAdminDisplayed();
		Assert.assertTrue(newadmin);
	}
}
