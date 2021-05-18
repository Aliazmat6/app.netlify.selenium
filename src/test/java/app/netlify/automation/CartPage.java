package app.netlify.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

//define all elements	
	By del=By.cssSelector("#root > main > div > div.row.no-gutters.justify-content-center > div.col-sm-9.p-3 > div > div > div > div.col-sm-4.p-2.text-right > button.btn.btn-danger.btn-sm.mb-1");
	By price = By.cssSelector("#root > main > div > div.row.no-gutters.justify-content-center > div.col-sm-9.p-3 > div > div > div > div:nth-child(2) > p");
	By tprice = By.cssSelector("#root > main > div > div.row.no-gutters.justify-content-center > div.col-sm-3.p-3 > div > h3");
	By clear= By.cssSelector("#root > main > div > div.row.no-gutters.justify-content-center > div.col-sm-3.p-3 > div > div > button.btn.btn-outlineprimary.btn-sm");
	By empty = By.cssSelector("#root > main > div > div.row.no-gutters.justify-content-center > div > div");
	By empty1 = By.cssSelector("#root > main > div > div.row.no-gutters.justify-content-center > div > div.p-3.text-center.text-muted"); 	
	
	By totalitems = By.cssSelector("#root > main > div > div.row.no-gutters.justify-content-center > div.col-sm-3.p-3 > div > h4");
	By totalpayment = By.cssSelector("#root > main > div > div.row.no-gutters.justify-content-center > div.col-sm-3.p-3 > div > h3");
	By delbutton = By.cssSelector("#root > main > div > div.row.no-gutters.justify-content-center > div.col-sm-9.p-3 > div > div > div > div.col-sm-4.p-2.text-right > button.btn.btn-danger.btn-sm.mb-1");
	By increase = By.cssSelector("#root > main > div > div.row.no-gutters.justify-content-center > div.col-sm-9.p-3 > div > div > div:nth-child(1) > div.col-sm-4.p-2.text-right > button.btn.btn-primary.btn-sm.mr-2.mb-1");
	

	By delete2 = By.cssSelector("#root > main > div > div.row.no-gutters.justify-content-center > div.col-sm-9.p-3 > div > div > div:nth-child(2) > div.col-sm-4.p-2.text-right > button.btn.btn-danger.btn-sm.mb-1");
	By checkout = By.cssSelector("#root > main > div > div.row.no-gutters.justify-content-center > div.col-sm-3.p-3 > div > div > button.btn.btn-primary.mb-2");

	By checkoutmsg = By.cssSelector("#root > main > div > div.row.no-gutters.justify-content-center > div > div.p-3.text-center.text-success > p");

	WebDriver driver;

	
public void increasequantity()	

{
	
driver.findElement(increase).click();

}

	
public CartPage(WebDriver driver) {

	this.driver=driver;
	
	// TODO Auto-generated constructor stub
}

public String findprice()
{
String p = driver.findElement(price).getText();
return p;
}

public String findtprice() {
	
String tp =	driver.findElement(tprice).getText();
return tp;
	
	
}
public void clickclear() {
	
	driver.findElement(clear).click();
}


public String totalitemnum()
{
String items = driver.findElement(totalitems).getText();	
return items;
	
}

public String totalpayment()
{
String tpayment = driver.findElement(totalpayment).getText();
return tpayment;
	
}




public String checkemptycart() {
	
String emp = driver.findElement(empty).getText();
return emp;
	
	

}


public boolean checkdel() {
	
	boolean del = driver.findElement(delbutton).isDisplayed();
	return del;
	
}


public void clickreduce()

{
driver.findElement(delbutton).click();	
	

	
}

public void clickdel2()

{
driver.findElement(delete2).click();	
		
}
public void clickcheckout()

{
driver.findElement(checkout).click();	
		
}

public String checkoutmessage()

{
String chkmsg = driver.findElement(checkoutmsg).getText()	;
return chkmsg;
}

public String emptycart1()
{
String emptycart1 =	driver.findElement(empty1).getText();
return emptycart1;
}



}
