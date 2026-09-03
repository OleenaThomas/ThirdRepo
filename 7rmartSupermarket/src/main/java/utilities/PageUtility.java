package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void dropdownElement(WebElement element, String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void dropdownElementByValue(WebElement element, String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public void dropdownElementByIndex(WebElement element) {
		Select select=new Select(element);
		select.selectByIndex(1);
	}
	
	public void scrollPageToBottom(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(document.body.scrollHeight)", "");
	}
	
	public void scrollPageToMid(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}
	
	public void clickElement(WebDriver driver, WebElement element) {
		Actions actions=new Actions(driver);
		actions.click(element).perform();
	}
}
