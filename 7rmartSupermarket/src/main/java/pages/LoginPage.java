package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {

	@FindBy(xpath="//input[@name='username']") WebElement usernamefield;
	@FindBy(xpath="//input[@name='password']")WebElement passwordfield;
	@FindBy(xpath="//button[@type='submit']")WebElement loginbutton;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//i[@class='icon fas fa-ban']")WebElement alertmessage;
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 /*
	public void login(String username, String password) {
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		loginbutton.click();
	}
	*/
	
	public LoginPage enterUsername(String username) {
		usernamefield.sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		passwordfield.sendKeys(password);
		return this;
	}
	
	public HomePage clickLoginButton() {
		loginbutton.click();
		return new HomePage(driver);
	}
	
	
	public boolean isDashboardDisplayed() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeVisible(driver, dashboard);
		return dashboard.isDisplayed();
	}
	
	public boolean isAlertMessageDisplayed() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeVisible(driver, alertmessage);
		return alertmessage.isDisplayed();
	}
}
