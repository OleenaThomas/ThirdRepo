package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends Base{

	@Test
	public void verifyUserCanCreateNews() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
		NewsPage newspage=new NewsPage(driver);
		newspage.createNews();
		boolean news=newspage.isNewsCreated();
		Assert.assertTrue(news);
		
	}
}
