package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	public void getScreenshot(WebDriver driver, String failedTestcase) throws IOException{
		TakesScreenshot takesscreenshot=(TakesScreenshot) driver;
		File screenshot=takesscreenshot.getScreenshotAs(OutputType.FILE);
		String timestamp=new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss").format(new Date());
		File f1=new File(System.getProperty("user.dir")+"//OutputScreenshot");
		
		if(!f1.exists()) {
			f1.mkdirs();
		}
		
		String destination=System.getProperty("user.dir")+"//OutputScreenshot//"+failedTestcase+timestamp+".png";
		File finaldestination=new File(destination);
		FileHandler.copy(screenshot, finaldestination);
	}
}
