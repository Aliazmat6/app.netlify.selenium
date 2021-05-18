package app.netlify.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;



public class StorePage {

	
	WebDriver driver;

	By cart = By.cssSelector("#root > header > a:nth-child(3)");
	By add= By.cssSelector("#root > main > div > div:nth-child(2) > div.ProductsGrid_p__grid__y0eGP > div:nth-child(1) > div > button");
	By add1 = By.cssSelector("#root > main > div > div:nth-child(2) > div.ProductsGrid_p__grid__y0eGP > div:nth-child(2) > div > button");
	
	
	
	public StorePage(WebDriver driver) {

		this.driver=driver;
		
		// TODO Auto-generated constructor stub
	}

	public void clickadd()
	
	{
		driver.findElement(add).click();
		
	}
	
	public void clickadd1()
	
	{
		driver.findElement(add1).click();
		
	}
	
public void clickcart() {
	
	driver.findElement(cart).click();
	
	
	
}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
