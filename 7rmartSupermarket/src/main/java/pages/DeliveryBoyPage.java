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
	@FindBy(xpath="//input[@id='name']")WebElement namefield;
	@FindBy(xpath="//input[@id='email']")WebElement emailfield;
	@FindBy(xpath="//input[@id='phone']")WebElement phonenumberfield;
	@FindBy(xpath="//textarea[@id='address']")WebElement addressfield;
	@FindBy(xpath="//input[@id='username']")WebElement usernamefield;
	@FindBy(xpath="//input[@id='password']")WebElement passwordfield;
	@FindBy(xpath="//button[@type='submit']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement deliveryboyalertmessage;

	public WebDriver driver;
	public DeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void createDeliveryBoy(String name, String email, int phone,String address, String dboyusername, String dboypassword) {
		deliveryboytile.click();
		newbutton.click();
		namefield.sendKeys(name);
		emailfield.sendKeys(email);
		phonenumberfield.sendKeys(String.valueOf(phone));
		addressfield.sendKeys(address);
		usernamefield.sendKeys(dboyusername);
		passwordfield.sendKeys(dboypassword);
		PageUtility pageutility=new PageUtility();
		pageutility.clickElement(driver, savebutton);
	}
	
	public boolean isDeliveryBoyCreated() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeVisible(driver, deliveryboyalertmessage);
		return deliveryboyalertmessage.isDisplayed();
	}
	
}
