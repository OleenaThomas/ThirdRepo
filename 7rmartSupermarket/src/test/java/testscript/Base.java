package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;

public class Base {

	public WebDriver driver;
	public Properties ps;
	public FileInputStream f;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void browserInitialization(String browser) throws Exception {
		try {
			ps=new Properties();
			f=new FileInputStream(Constant.CONFIGFILE);
			ps.load(f);
		}catch (Exception e) {
			System.out.println(e);
		}
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			throw new Exception ("invalid");
		}
		
		//driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/");
		driver.get(ps.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	
	@AfterMethod(alwaysRun=true)
	/*
	public void closeBrowser() {
		driver.quit();
	}
	*/
	
	public void browserQuit(ITestResult iTestResult) throws IOException{
		if(iTestResult.getStatus()==ITestResult.FAILURE) {
			ScreenshotUtility screenshotutility=new ScreenshotUtility();
			screenshotutility.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();
	}
}
