package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DeliveryBoyPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class DeliveryBoyTest extends Base{

	@Test
	public void verifyUserCanCreateDeliveryBoy() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		DeliveryBoyPage deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.createDeliveryBoy();
		boolean deliveryboy=deliveryboypage.isDeliveryBoyCreated();
		Assert.assertTrue(deliveryboy);
	}
}
