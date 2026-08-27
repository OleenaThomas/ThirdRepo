package testscript;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base{

	HomePage homepage;
	@Test(groups= {"regression"},description="creates new category")
	public void verifyUserCanCreateCategory() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username)
		.enterPassword(password);
		homepage=loginpage.clickLoginButton();
		
		String categoryname=ExcelUtility.getStringData(1, 0, "categorypage");
		CategoryPage categorypage=new CategoryPage(driver);
		categorypage.createCategory(categoryname);
		boolean category=categorypage.isCategoryCreated();
		Assert.assertTrue(category);
	}
}
