package day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FurnitureSelectionAmazon 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement categoryType = driver.findElementById("searchDropdownBox");
		Select selectCategoryByVisibleText=new Select(categoryType);
		selectCategoryByVisibleText.selectByVisibleText("Furniture");
		driver.findElementById("twotabsearchtextbox").sendKeys("Chairs for Computer Table");
		driver.findElementByXPath("//input[@value='Go']").click();
		List<WebElement> officeChairList = driver.findElementsByXPath("//span[contains(text(), 'Chair')]");
		List<WebElement> officeChairListPrice = driver.findElementsByXPath("//span[contains(text(), 'Chair')]/following::span[@class='a-price-whole']");
		Thread.sleep(3000);
		//System.out.println(officeChairListPrice.size());
		
		List<String> priceList = new LinkedList<String>();
		
		for (int i = 0; i < officeChairListPrice.size(); i++) 
		{
//			String text = officeChairListPrice.get(i).getText();
//			System.out.println(text);
			
			priceList.add(officeChairListPrice.get(i).getText().replaceAll(",", ""));
			//System.out.println(priceList.get(i));
		}
		List<Integer> priceListValues=new ArrayList();
		for (int i = 0; i < priceList.size(); i++) 
		{
			priceListValues.add(Integer.parseInt(priceList.get(i)));
		}
		Collections.sort(priceListValues);
		int size1 = priceListValues.size();
		System.out.println(size1);
	int bigValue = priceListValues.get(size1-1);
		System.out.println(bigValue);
	String bigValueString = Integer.toString(bigValue);
	System.out.println(bigValueString);
		String text = driver.findElementByXPath("//*[starts-with(text(),'"+bigValueString.substring(0, 1)+"')]/preceding::span[12]").getText();
		System.out.println(text);
//		for (Integer values : priceListValues) 
//		{
//			System.out.println(values);
//		}
		
		
		//System.out.println(priceList);
		
//		Map<String, String> newMap=new HashedMap<String, String>();
//		for (int i = 0; i <= officeChairList.size()-1; i++) 
//		{
//				newMap.put(officeChairList.get(i).getText(), officeChairListPrice.get(i).getText());
//		}
//		for (Entry<String, String> mapValue : newMap.entrySet()) 
//		{
//			System.out.println(mapValue);
//		}
		//driver.quit();
		
	}

}
