package app.netlify.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;




public class scenario1 {

	WebDriver driver;
	String URL= "https://react-shooping-cart.netlify.app/";

	setup set = new setup();

	

	@Test
	@Parameters({"browser","bsbrowser","browserv","bsos","bsosv","tname"})
	public void s1(String browser,@Optional("") String bsbrowser, @Optional("") String bsbrowserv, @Optional("") String bsos,@Optional("") String bsosv,@Optional("")String tname) throws Exception {
		

		
		
		driver =	set.Setup(browser,bsbrowser,bsbrowserv,bsos,bsosv,tname);

	

		driver.get(URL);
		


try

{
		
		StorePage spage = new StorePage(driver);
		CartPage cpage = new CartPage(driver);
		spage.clickadd();
		spage.clickcart();
		String empcarttext = cpage.checkemptycart();
			
		Assert.assertNotEquals("Your cart is empty",empcarttext);
		String price =	cpage.findprice();
		Assert.assertNotNull(price);
        boolean delcheck = cpage.checkdel();
       Assert.assertTrue(delcheck);
        String items =	cpage.totalitemnum();
		Assert.assertNotNull(items);
		String tpayments =	cpage.totalpayment();
		Assert.assertNotNull(tpayments);
		cpage.clickclear();
		empcarttext = cpage.checkemptycart();
		Assert.assertEquals("Your cart is empty" ,empcarttext);

			driver.quit();
}


finally {
	
	driver.quit();
	
	
}
	}		



	
	

}
