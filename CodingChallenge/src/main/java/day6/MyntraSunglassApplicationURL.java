package day6;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraSunglassApplicationURL
{
	public static ChromeDriver driver;
	
	public void browserApplication() 
	{
		try 
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions=new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--disable-Notification");
			driver=new ChromeDriver(chromeOptions);
			System.out.println("The window Dimensions before Mazimized:-" +driver.manage().window().getSize());
			System.out.println("The window Dimensions after Maximized:-" +driver.manage().window().getSize());
			driver.manage().window().maximize();
			driver.get("https://www.myntra.com");
			//return(driver);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void broserClose() 
	{
		driver.close();
	}

}
