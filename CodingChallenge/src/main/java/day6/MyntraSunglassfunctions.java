package day6;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MyntraSunglassfunctions extends MyntraSunglassApplicationURL
{
	public void searchByProduct() throws InterruptedException 
	{
		try 
		{
			Thread.sleep(3000);
			WebElement search = driver.findElementByXPath("//*[@placeholder='Search for products, brands and more']");
			search.clear();
			search.sendKeys("Sun Glasses");
			search.sendKeys(Keys.ENTER);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void filterByBrand() throws InterruptedException 
	{
		try 
		{
			driver.findElementByXPath("//*[@class='brand-more']").click();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(3000);
			WebElement Polaroid = driver.findElementByXPath("//input[@value='Polaroid']/following::div[@class='common-checkboxIndicator'][1]");
			Polaroid.click();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void totalProduct() throws InterruptedException 
	{
		try 
		{
			driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
			List<WebElement> listOfProducts = driver.findElementsByXPath("//h4[@class='product-product']");
			System.out.println("The Total Number of Products Available:-"+listOfProducts.size());
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void filterByGenderAndType() throws InterruptedException 
	{
		try 
		{
			driver.findElementByXPath("//*[@class='gender-list']/li[1]/label").click();
			driver.findElementByXPath("//div[@class='atsa-more']").click();
			driver.findElementByXPath("//*[@class='atsa-title']/following::h4[contains(text(), 'Type')]").click();
			Thread.sleep(3000);
			List<WebElement> sunglassesTypes = driver.findElementsByXPath("//ul[@class='atsa-values']/li/label");
			for (int i = 0; i < sunglassesTypes.size(); i++) 
			{
				if (sunglassesTypes.get(i).getText().contains("Rectangle Sunglasses")) 
				{
					sunglassesTypes.get(i).click();
				}	
			}
			
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void simillarProducts() throws InterruptedException 
	{
		try 
		{
			WebElement product = driver.findElementByXPath("//img[1]");
			WebElement viewSimillarItems = driver.findElementByXPath("//span[contains(text(),'VIEW SIMILAR')][1]");
			//Action Class to Move to product ==> Simillar Items 
			Actions builder=new Actions(driver);
			builder.moveToElement(product)
				   .moveToElement(viewSimillarItems)
				   .click()
				   .build()
				   .perform();
			Thread.sleep(3000);
			List<WebElement> simillarProducts = driver.findElementsByXPath("//*[contains(text(),'Similar Products')]/following::div/picture");
			System.out.println("The Total Number of |||ar Product based on the Search Criteria:-" +simillarProducts.size());
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
