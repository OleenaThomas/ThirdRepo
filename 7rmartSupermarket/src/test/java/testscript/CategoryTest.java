package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base{

	@Test
	public void verifyUserCanCreateCategory() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		String categoryname=ExcelUtility.getStringData(1, 0, "categorypage");
		CategoryPage categorypage=new CategoryPage(driver);
		categorypage.createCategory(categoryname);
		boolean category=categorypage.isCategoryCreated();
		Assert.assertTrue(category);
	}
}
