package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base{

	@Test(groups= {"regression"},description="creates new category")
	public void verifyUserCanCreateCategory() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		String categoryname=ExcelUtility.getStringData(1, 0, "categorypage");
		CategoryPage categorypage=new CategoryPage(driver);
		categorypage.createCategory(categoryname);
		boolean category=categorypage.isCategoryCreated();
		AssertJUnit.assertTrue(category);
	}
}
