package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class NewsPage {

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement newstile;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']")WebElement newstextbox;
	@FindBy(xpath="//button[@type='submit']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement newsalertmessage;

	public WebDriver driver;
	public NewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createNews(String newstext) {
		PageUtility pageutility=new PageUtility();
		pageutility.clickElement(driver, newstile);
		newbutton.click();
		newstextbox.sendKeys(newstext);
		savebutton.click();
	}
	
	public boolean isNewsCreated() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeVisible(driver, newsalertmessage);
		return newsalertmessage.isDisplayed();
	}
}
