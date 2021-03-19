package Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import objectRepository.AmazonHomePage;
import objectRepository.AmazonNewWindowPage;
import objectRepository.FlipkartHomePage;
import objectRepository.FlipkartNewWindowPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindBestPrice {

	WebDriver driver;
	WebDriverWait wait;
	String parentwindow;
	int amazon_price;
	int flipkart_price;
	
	@BeforeTest
	public void initialyze() throws InterruptedException{
		System.setProperty("Webdriver.chrome.driver", "C:\\chromedriver_win32.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,20);
		parentwindow = driver.getWindowHandle();
	}
	
	@Test(priority =1)
	public void amazonprice() throws InterruptedException
	{
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//To get the price from Amazon
		AmazonHomePage ap = new AmazonHomePage(driver);
		ap.search().sendKeys("iPhone XR (64GB) - Black");
		ap.searchicon().click();
		ap.waitforamazontitle(wait);
		for(WebElement e1 : ap.elementslist()){
			if(e1.getText().contains("Apple iPhone 12 (64GB) - Black"))
			{
				ap.title().click();
			}
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Set<String> S1 = driver.getWindowHandles();
		for(String childwindow : S1){
			
			if(!(childwindow.equalsIgnoreCase(parentwindow))){
				driver.switchTo().window(childwindow);
			}
		}
		AmazonNewWindowPage anw = new AmazonNewWindowPage(driver);
		anw.product_title().isDisplayed();
		String amazon_price1 = anw.amazon_price().getText();
		String []a = amazon_price1.split(" ");
		String amazon_price2=a[1];
		String amazon_price3 = amazon_price2.substring(0, 2) + amazon_price2.substring(2 + 1);
		amazon_price3 = amazon_price3.substring(0, amazon_price3.length() - 3);
		amazon_price = Integer.parseInt(amazon_price3);
		System.out.println("Amazon Price: "+amazon_price);
		driver.close();
		driver.switchTo().window(parentwindow);
	}
	
	@Test(priority =2)
	public void flipkartprice(){
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		//To get the price from Flipkart
		FlipkartHomePage fp = new FlipkartHomePage(driver);
		fp.crossicon().click();
		fp.search().sendKeys("iPhone XR (64GB) Black");
		fp.searchicon().click();
		fp.waitforflipkarttitle(wait);
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		for(WebElement e1 : fp.elementslist()){
			if(e1.getText().contains("Apple iPhone XR (Black, 64 GB)"))
			{
				fp.title().click();
			}
		}
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		Set<String> S2 = driver.getWindowHandles();
		for(String childwindow : S2){
			
			if(!(childwindow.equalsIgnoreCase(parentwindow))){
				
				driver.switchTo().window(childwindow);
				
				}
			}

		FlipkartNewWindowPage fpw = new FlipkartNewWindowPage(driver);
		fpw.product_title().isDisplayed();
		String flipkart_price1 = fpw.flipkart_price().getText();
		String flipkart_price2= flipkart_price1.substring(1);
		String flipkart_price3 = flipkart_price2.substring(0, 2) + flipkart_price2.substring(2 + 1);
		flipkart_price = Integer.parseInt(flipkart_price3);
		System.out.println("Flipkart Price: "+flipkart_price);
		driver.close();
		driver.switchTo().window(parentwindow);
	}
	
	@Test(priority =3
			)
	public void compareprice(){
		if(amazon_price > flipkart_price)
		{
			System.out.println("Flipkart has lesser price for iPhone when compared to Amazon");
		}
		else
		{
			System.out.println("Amazon has lesser price for iPhone when compared to Flipkart");
		}
		
	}
	
	@AfterTest
	public void quitBrowser(){
		driver.quit();
	}
}
