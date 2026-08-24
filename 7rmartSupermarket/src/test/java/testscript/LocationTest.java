package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import pages.LocationPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LocationTest extends Base {

	@Test(groups= {"regression"},description="creates new location")
	public void verifyUserCanCreateLocation() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		String location=ExcelUtility.getStringData(1, 0, "locationpage");
		int deliverycharge=ExcelUtility.getNumericData(1, 1, "locationpage");
		LocationPage locationpage=new LocationPage(driver);
		locationpage.createLocation(location,deliverycharge);
		boolean newlocation=locationpage.isLocationCreated();
		AssertJUnit.assertTrue(newlocation);
	}
}
