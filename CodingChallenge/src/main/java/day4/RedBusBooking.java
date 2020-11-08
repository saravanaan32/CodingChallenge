package day4;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusBooking 
{
	public static void main(String[] args) throws InterruptedException 
	{
	//Open Browser - In Eclipse -> Window -> Show View -> Other -> Choose Git
	WebDriverManager.chromedriver().setup();
	ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("--start-maximized");
	chromeOptions.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(chromeOptions);
	
	//WebDriverManager.edgedriver().setup();
	//EdgeDriver driver=new EdgeDriver();
	
	driver.manage().window().maximize();
	driver.get("https://www.redbus.in/");
	
	//Display the Browser version
	String version = driver.getCapabilities().getVersion();		
	System.out.println("Version is : " + version);
	
	//Pass value in "To" field
	WebElement toCity = driver.findElementByXPath("//input[@data-message='Please enter a destination city']");
	toCity.clear();
	toCity.sendKeys("Bangalore (All Locations)");
	Thread.sleep(4000);

	//Pass value in "From" Field
	String fromCityString = Keys.chord(Keys.SHIFT, Keys.TAB, "Chennai (All Locations)");
	toCity.sendKeys(fromCityString);
	Thread.sleep(4000);

	//Calender value selection
	driver.findElementById("onward_cal").click();
	driver.findElementByXPath("//td[@class='next']").click();
	
	List<WebElement> calendarDays = driver.findElementsByXPath("//th[contains(text(),'Mo')]/following::tr/td[1]");
	List<String> mondays=new ArrayList<String>();
	for (WebElement days : calendarDays) 
	{
		//System.out.println(days.getText());
		if (!days.getText().isEmpty()) 
		{
			mondays.add(days.getText());
		}
		
	}
	String mondayValue=mondays.get(0);
	driver.findElementByXPath("//td[contains(text(),'"+mondayValue+"')]").click();
		
	//Click on Search
	driver.findElementByXPath("//button[@id='search_btn']").click();
	System.out.println("Search Button Clicked!!!");
	Thread.sleep(5000);

	//Select the no of buses comes in search result
	List<WebElement> busList = driver.findElementsByXPath("//div[@class='travels lh-24 f-bold d-color']");
	System.out.println("Totally we have " + busList.size() + " buses are available based on the Search Criteria !!!");
	for (int i = 0; i < busList.size(); i++) 
		{
			System.out.println(busList.get(i).getText());
		}
	}

}
