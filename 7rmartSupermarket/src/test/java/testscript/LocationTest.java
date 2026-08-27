package testscript;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

import pages.HomePage;
import pages.LocationPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LocationTest extends Base {
	HomePage homepage;
	@Test(groups= {"regression"},description="creates new location")
	public void verifyUserCanCreateLocation() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username)
		.enterPassword(password);
		homepage=loginpage.clickLoginButton();
		
		String location=ExcelUtility.getStringData(1, 0, "locationpage");
		int deliverycharge=ExcelUtility.getNumericData(1, 1, "locationpage");
		LocationPage locationpage=new LocationPage(driver);
		locationpage.createLocation(location,deliverycharge);
		boolean newlocation=locationpage.isLocationCreated();
		Assert.assertTrue(newlocation);
	}
}
