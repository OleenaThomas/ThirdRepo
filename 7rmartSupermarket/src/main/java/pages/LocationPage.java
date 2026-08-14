package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LocationPage {

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location' and @class='small-box-footer']")WebElement locationtile;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
	@FindBy(xpath="//select[@id='country_id']")WebElement country;
	@FindBy(xpath="//select[@id='st_id']")WebElement state;
	@FindBy(xpath="//input[@id='location']")WebElement location;
	@FindBy(xpath="//input[@id='delivery']")WebElement deliverycharge;
	@FindBy(xpath="//button[@type='submit']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement locationalertmessage;
	
	public WebDriver driver;
	public LocationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void createLocation() {
		locationtile.click();
		newbutton.click();
		PageUtility pageutility=new PageUtility();
		pageutility.dropdownElement(country,"United Kingdom");
		pageutility.dropdownElement(state, "Belfast");
		location.sendKeys("London");
		deliverycharge.sendKeys("50");
		savebutton.click();
	}
	
	public boolean isLocationCreated() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeVisible(driver, locationalertmessage);
		return locationalertmessage.isDisplayed();
	}

}
