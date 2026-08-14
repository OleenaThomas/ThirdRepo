package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoryPage {

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement categorytile;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
	@FindBy(xpath="//input[@id='category']")WebElement categoryfield;
	@FindBy(xpath="//li[@id='1-selectable']")WebElement selectgroup1;
	@FindBy(xpath="//li[@id='2-selectable']")WebElement selectgroup2;
	@FindBy(xpath="//input[@id='main_img']")WebElement choosefile;
	@FindBy(xpath="//input[@name='top_menu' and @value='yes']")WebElement topmenubutton;
	@FindBy(xpath="//input[@name='show_home' and @value='yes']")WebElement leftmenubutton;
	@FindBy(xpath="//button[@type='submit']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement categoryalertmessage;

	public WebDriver driver;
	public CategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void createCategory(String categoryname) {
		PageUtility pageutility=new PageUtility();
		pageutility.clickElement(driver, categorytile);
		
		newbutton.click();
		categoryfield.sendKeys(categoryname);
		selectgroup1.click();
		selectgroup2.click();
		
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(choosefile, Constant.APPLEIMG);
		topmenubutton.isSelected();
		leftmenubutton.isSelected();
		pageutility.clickElement(driver, savebutton);
	}

	public boolean isCategoryCreated() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeVisible(driver, categoryalertmessage);
		return categoryalertmessage.isDisplayed();
	}
}
