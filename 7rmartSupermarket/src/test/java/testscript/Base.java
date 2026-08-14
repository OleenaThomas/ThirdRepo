package testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	public WebDriver driver;
	@BeforeMethod
	public void browserInitialization() {
		driver=new ChromeDriver();
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/");
		driver.manage().window().maximize();
	}
	
	//@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
