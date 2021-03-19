package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonNewWindowPage {
	WebDriver driver;
	public AmazonNewWindowPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	By amazon_price = By.xpath("//span[@class='a-size-medium a-color-price priceBlockBuyingPriceString']");
    By product_title = By.xpath("//span[@id='productTitle']");
    		
	public WebElement amazon_price(){
		return driver.findElement(amazon_price);
	}
	public WebElement product_title(){
		return driver.findElement(product_title);
	}
}
