package day6;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraSunglassShopping 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.addArguments("--incognito");
		chromeOptions.addArguments("--disable-Notification");
		ChromeDriver driver=new ChromeDriver(chromeOptions);
		System.out.println("The window Dimensions before Mazimized:-" +driver.manage().window().getSize());
		System.out.println("The window Dimensions after Maximized:-" +driver.manage().window().getSize());
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com");
		Thread.sleep(3000);
		WebElement search = driver.findElementByXPath("//*[@placeholder='Search for products, brands and more']");
		search.clear();
		search.sendKeys("Sun Glasses");
		search.sendKeys(Keys.ENTER);
		driver.findElementByXPath("//*[@class='brand-more']").click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		WebElement Polaroid = driver.findElementByXPath("//input[@value='Polaroid']/following::div[@class='common-checkboxIndicator'][1]");
		Polaroid.click();
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		List<WebElement> listOfProducts = driver.findElementsByXPath("//h4[@class='product-product']");
		System.out.println("The Total Number of Products Available:-"+listOfProducts.size());
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@class='gender-list']/li[1]/label").click();
		driver.findElementByXPath("//div[@class='atsa-more']").click();
		driver.findElementByXPath("//*[@class='atsa-title']/following::h4[contains(text(), 'Type')]").click();
		
		
		
		Thread.sleep(3000);
		//driver.findElementByXPath("//ul[@class='atsa-values']/li[7]/label").click();
		driver.findElementByXPath("//label[@class='common-customCheckbox']/following::input[@value='Rectangle Sunglasses']/../div").click();
		
		
		
		WebElement product = driver.findElementByXPath("//img[1]");
		WebElement viewSimillarItems = driver.findElementByXPath("//span[contains(text(),'VIEW SIMILAR')][1]");
		Actions builder=new Actions(driver);
		builder.moveToElement(product)
			   .moveToElement(viewSimillarItems)
			   .click()
			   .build()
			   .perform();
		Thread.sleep(3000);
		List<WebElement> simillarProducts = driver.findElementsByXPath("//*[contains(text(),'Similar Products')]/following::div/picture");
		System.out.println("The Total Number of |||ar Product based on the Search Criteria:-" +simillarProducts.size());
		driver.close();
	}

}
