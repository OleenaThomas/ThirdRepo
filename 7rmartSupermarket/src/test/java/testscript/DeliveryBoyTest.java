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
		String name=ExcelUtility.getStringData(1, 0, "deliveryboypage");
		String email=ExcelUtility.getStringData(1, 1, "deliveryboypage");
		double phone=ExcelUtility.getNumericData(1, 2, "deliveryboypage");
		String address=ExcelUtility.getStringData(1, 3, "deliveryboypage");
		String dboyusername=ExcelUtility.getStringData(1, 4, "deliveryboypage");
		String dboypassword=ExcelUtility.getStringData(1, 5, "deliveryboypage");
		deliveryboypage.createDeliveryBoy(name,email,phone,address,dboyusername,dboypassword);
		
		boolean deliveryboy=deliveryboypage.isDeliveryBoyCreated();
		Assert.assertTrue(deliveryboy);
	}
}
