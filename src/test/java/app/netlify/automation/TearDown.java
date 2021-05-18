package app.netlify.automation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TearDown {

	public void td(WebDriver driver)
	
	{
		
		driver.quit();
		
		
		
	}
	public void Sshot(WebDriver driver,String tname) throws IOException
    {
        Date date = new Date();
        SimpleDateFormat dformat  = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss.SSS");        
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,  new File("D:\\new\\"+tname+dformat.format(date)+".png"));
    }

	

}
