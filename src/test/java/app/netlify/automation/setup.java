package app.netlify.automation;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;


public class setup 

{
	
	WebDriver driver;
	public static final String USERNAME = "azmat3";
	public static final String AUTOMATE_KEY = "pHchLNUxZiGgzCHahRHx";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
//	String browser;

	
public WebDriver Setup(String browser,String bsbrowser,String bsbrowserv, String bsos,String osv, String tName )  throws Exception
{
	if(browser.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver","d:/chromedriver.exe");
	   	
	 	driver= new ChromeDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("firefox")){

			System.setProperty("webdriver.gecko.driver", "d:/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		}
		else if(browser.equalsIgnoreCase("edge")){
					System.setProperty("webdriver.edge.driver","d:/msedgedriver.exe");
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
			
			

			driver = new RemoteWebDriver(new URL(URL), caps);
		}
	
	
		else
		{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}	
	return driver;	

}


}
