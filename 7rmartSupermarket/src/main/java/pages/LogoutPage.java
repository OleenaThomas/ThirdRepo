package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	@FindBy(xpath="//a[@data-toggle='dropdown' and @href='#']")WebElement dasboardicon;
	@FindBy(xpath="//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logoutbutton;
	
	public WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logout() {
		dasboardicon.click();
		logoutbutton.click();
	}
	
	public String isLoginPage() {
		return driver.getTitle();
	}
}
