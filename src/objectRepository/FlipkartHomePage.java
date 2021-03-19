package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartHomePage {

	WebDriver driver;
	public FlipkartHomePage(WebDriver driver){
		
		this.driver = driver;
	}
	
	By search = By.xpath("//input[@name='q']");
	By searchicon = By.xpath("//button[@class='L0Z3Pu']");
	By title = By.xpath("//div[contains(text(),'Apple iPhone XR (Black, 64 GB)')]");
	By crossicon = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	By elementslist = By.xpath("//div[@class='_4rR01T']");
	By waitforflipkarttitle = By.xpath("//div[contains(text(),'Apple iPhone XR (Black, 64 GB)')]");
	
	
	public WebElement search(){
		return driver.findElement(search);
	}
	
	public WebElement searchicon(){
		
		return driver.findElement(searchicon);
	}
	
	public WebElement title(){
		return driver.findElement(title);
	
	}
	public WebElement crossicon(){
		return driver.findElement(crossicon);
	
	}
	public List <WebElement> elementslist(){
		return driver.findElements(elementslist);
	}
	public WebElement waitforflipkarttitle(WebDriverWait wait){
		return wait.until(ExpectedConditions.visibilityOfElementLocated(waitforflipkarttitle));
	}
}
