package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminTest extends Base{

	@Test(groups= {"regression"})
	public void verifyNewAdminIsCreated() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		String adminusername=ExcelUtility.getStringData(1, 0, "adminpage");
		String adminpassword=ExcelUtility.getStringData(1, 1, "adminpage");
		AdminPage adminpage=new AdminPage(driver);
		adminpage.createAdmin(adminusername, adminpassword);
		boolean newadmin=adminpage.isNewAdminDisplayed();
		AssertJUnit.assertTrue(newadmin);
	}
}
