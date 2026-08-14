package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class DeliveryBoyPage {

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']")WebElement deliveryboytile;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
	@FindBy(xpath="//input[@id='name']")WebElement name;
	@FindBy(xpath="//input[@id='email']")WebElement email;
	@FindBy(xpath="//input[@id='phone']")WebElement phonenumber;
	@FindBy(xpath="//textarea[@id='address']")WebElement address;
	@FindBy(xpath="//input[@id='username']")WebElement username;
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement deliveryboyalertmessage;

	public WebDriver driver;
	public DeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void createDeliveryBoy() {
		deliveryboytile.click();
		newbutton.click();
		name.sendKeys("John Smith");
		email.sendKeys("johnsmith@gmail.com");
		phonenumber.sendKeys("123445");
		address.sendKeys("ABC Ave");
		username.sendKeys("johns");
		password.sendKeys("johns");
		PageUtility pageutility=new PageUtility();
		pageutility.clickElement(driver, savebutton);
	}
	
	public boolean isDeliveryBoyCreated() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeVisible(driver, deliveryboyalertmessage);
		return deliveryboyalertmessage.isDisplayed();
	}
	
}
