package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {

	WebDriver driver;
	public AmazonHomePage(WebDriver driver){
		
		this.driver = driver;
	}
	
	By search = By.id("twotabsearchtextbox");
	By searchicon = By.xpath("//div[@class='nav-search-submit nav-sprite']");
	By title = By.xpath("//span[contains(text(),'Apple iPhone 12 (64GB) - Black')]");
	By amazon_price = By.xpath("//span[@id='priceblock_dealprice']");
	By elementslist = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	By waitforamazontitle = By.xpath("//span[contains(text(),'Apple iPhone 12 (64GB) - Black')]");
	
	public WebElement search(){
		return driver.findElement(search);
	}
	
	public WebElement searchicon(){
		
		return driver.findElement(searchicon);
	}
	
	public WebElement title(){
		return driver.findElement(title);
	}
	
	public WebElement amazon_price(){
		return driver.findElement(amazon_price);
	}
	
	public List <WebElement> elementslist(){
		return driver.findElements(elementslist);
	}
	public WebElement waitforamazontitle(WebDriverWait wait){
		return wait.until(ExpectedConditions.visibilityOfElementLocated(waitforamazontitle));
	}
}
