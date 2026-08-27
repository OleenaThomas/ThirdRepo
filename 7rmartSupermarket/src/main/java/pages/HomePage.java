package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

// this is a class copied from LogoutPage to demonstrate chaining
public class HomePage {
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement admintile;

	// LogoutPage web elements
	@FindBy(xpath="//a[@data-toggle='dropdown' and @href='#']")
	WebElement dashboardicon;
	@FindBy(xpath="//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logoutbutton;
	
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage clickLoginButton() {
		loginbutton.click();
		return new HomePage(driver);
		
	}
	
	public AdminPage clickAdminMoreInfo() {
		admintile.click();
		return new AdminPage(driver);
	}
	
	//LogoutPage methods
	
	public void logout() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeVisible(driver, dashboardicon);
		dashboardicon.click();
		logoutbutton.click();
	}
	
	public String isLoginPage() {
		return driver.getTitle();
	}
}
