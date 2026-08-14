package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LogoutPage {

	@FindBy(xpath="//a[@data-toggle='dropdown' and @href='#']")WebElement dashboardicon;
	@FindBy(xpath="//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logoutbutton;
	
	public WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
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
