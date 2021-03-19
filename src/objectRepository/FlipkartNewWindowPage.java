package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartNewWindowPage {

	WebDriver driver;
	public FlipkartNewWindowPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	By flipkart_price = By.xpath("//div[@class='_30jeq3 _16Jk6d']");
	By product_title = By.xpath("//span[@class='B_NuCI']");
	
	public WebElement flipkart_price(){
		return driver.findElement(flipkart_price);
	}
	public WebElement product_title(){
		return driver.findElement(product_title);
	}
}
