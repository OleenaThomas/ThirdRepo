package testscript;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends Base{
	HomePage homepage;
	@Test(groups= {"regression"}, description="adds new news")
	public void verifyUserCanCreateNews() throws IOException {
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username)
		.enterPassword(password);
		homepage=loginpage.clickLoginButton();
		
		String newstext=ExcelUtility.getStringData(1, 0, "newspage");
		NewsPage newspage=new NewsPage(driver);
		newspage.createNews(newstext);
		boolean news=newspage.isNewsCreated();
		Assert.assertTrue(news);
		
	}
}
