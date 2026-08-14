package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LocationPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LocationTest extends Base {

	@Test
	public void verifyUserCanCreateLocation() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		LocationPage locationpage=new LocationPage(driver);
		locationpage.createLocation();
		boolean location=locationpage.isLocationCreated();
		Assert.assertTrue(location);
	}
}
