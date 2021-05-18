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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class scenario2 
{
	String URL= "https://react-shooping-cart.netlify.app/";
	WebDriver driver;
	TearDown t = new TearDown();
	setup set = new setup();
	
@Test
@Parameters({"browser","bsbrowser","bsbrowserv","bsos","bsosv","tname"})
public void s2(String browser,@Optional("") String bsbrowser, @Optional("") String bsbrowserv, @Optional("") String bsos,@Optional("") String bsosv,@Optional("")String tname) throws Exception {
		
	driver =	set.Setup(browser,bsbrowser,bsbrowserv,bsos,bsosv,tname);
		try
		{
			driver.get(URL);
			StorePage spage = new StorePage(driver);
			CartPage cpage = new CartPage(driver);
			spage.clickadd();
			spage.clickadd1();
			t.Sshot(driver,tname);

			spage.clickcart();
			t.Sshot(driver,tname);

			cpage.increasequantity();
			cpage.increasequantity();
			t.Sshot(driver,tname);

			String items =	cpage.totalitemnum();
			Assert.assertEquals("4",items);
			t.Sshot(driver,tname);

			String tpayments =	cpage.totalpayment();
			Assert.assertEquals("$375.25",tpayments);
			t.Sshot(driver,tname);

			boolean delcheck = cpage.checkdel();
			Assert.assertTrue(delcheck);
			cpage.clickreduce();
			items =	cpage.totalitemnum();
			Assert.assertEquals("3",items);
			t.Sshot(driver,tname);

			tpayments =	cpage.totalpayment();
			Assert.assertEquals("$336.14",tpayments);
			cpage.clickdel2();
			items =	cpage.totalitemnum();
			Assert.assertEquals("2",items);
			t.Sshot(driver,tname);

			cpage.clickcheckout();
			String checkoutmessage = cpage.checkoutmessage();
			Assert.assertEquals("Checkout successfull",checkoutmessage);
			String emptycartmsg1 = cpage.emptycart1();
			Assert.assertEquals("Your cart is empty",emptycartmsg1);
			t.Sshot(driver,tname);

		}
		finally
		{
			t.td(driver);			
		}
}
}
