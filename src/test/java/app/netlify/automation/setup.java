package app.netlify.automation;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


import io.github.bonigarcia.wdm.WebDriverManager;


public class setup 

{
	
	WebDriver driver;
	public static final String USERNAME = "azmat3";
	public static final String AUTOMATE_KEY = "pHchLNUxZiGgzCHahRHx";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	
public WebDriver Setup(String browser,String bsbrowser,String bsbrowserv, String bsos,String osv, String tName )  throws Exception
{
	if(browser.equalsIgnoreCase("chrome")){

		WebDriverManager.chromedriver().setup();
	 	driver= new ChromeDriver();
		driver.manage().window().maximize();
		
	}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("firefox")){

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
	
		}
		else if(browser.equalsIgnoreCase("edge")){
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					driver.manage().window().maximize();

		}
	
		else if(browser.equalsIgnoreCase("browserstack"))
		
		{
		
			
			DesiredCapabilities caps = new DesiredCapabilities();
	        
			caps.setCapability("os", bsos);
			caps.setCapability("os_version", osv);
			caps.setCapability("browser", bsbrowser);
			caps.setCapability("browser_version", bsbrowserv);
			caps.setCapability("name", tName);
			caps.setCapability("browserstack.debug", "true");
			

			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.manage().window().maximize();

			
		}
	
		else if (browser.equalsIgnoreCase("Android")||(browser.equalsIgnoreCase("IOS")))	
		{
			
			DesiredCapabilities caps = new DesiredCapabilities();
			
			caps.setCapability("device", bsos);
			caps.setCapability("os_version", osv);
			caps.setCapability("real_mobile", "true");
			caps.setCapability("name", tName);
			caps.setCapability("console", "errors");
			caps.setCapability("browserstack.debug", "true");

			

			driver = new RemoteWebDriver(new URL(URL), caps);
		}
	
	
		else
		{
			throw new Exception("Browser is not correct");
		}	
	
	return driver;	

}
}
