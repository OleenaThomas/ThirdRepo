package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement admintile;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
	@FindBy(xpath="//input[@id='username']")WebElement adminusernamefield;
	@FindBy(xpath="//input[@id='password']")WebElement adminpasswordfield;
	@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
	@FindBy(xpath="//button[@name='Create']")WebElement createadmin;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement newadminalert;
	
	public WebDriver driver;
	public AdminPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createAdmin(String adminusername, String adminpassword) {
		admintile.click();
		newbutton.click();
		adminusernamefield.clear();
		adminusernamefield.sendKeys(adminusername);
		adminpasswordfield.clear();
		adminpasswordfield.sendKeys(adminpassword);
		
		//selecting from drop-down 	
		PageUtility pageutility=new PageUtility();
		pageutility.dropdownElement(usertype, "Admin");
		createadmin.click();
	}
	
	public boolean isNewAdminDisplayed() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeVisible(driver, newadminalert);
		return newadminalert.isDisplayed();
	}
}
