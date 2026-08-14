package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

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
	public void login(String username, String password) {
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		loginbutton.click();
	}
	
	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}
	
	public boolean isAlertMessageDisplayed() {
		return alertmessage.isDisplayed();
	}
}
