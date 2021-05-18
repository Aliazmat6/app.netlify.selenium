package app.netlify.automation;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class bstack {
	
	public static final String USERNAME = "azmat3";
	public static final String AUTOMATE_KEY = "pHchLNUxZiGgzCHahRHx";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	static RemoteWebDriver driver;
	

	
	@Test
	public RemoteWebDriver  bsetup ()


{
	
		
			
		DesiredCapabilities caps = new DesiredCapabilities();
        
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "80");
		caps.setCapability("name", "azmat3's First Test");
		

		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		
			driver.get("https://react-shooping-cart.netlify.app/");		

//			return driver;

		
		
	} 
		
		
		
		
		catch (MalformedURLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			driver.quit();
		}
		
		
return driver;
	
	
	
	
	
	
}
	
	


}
