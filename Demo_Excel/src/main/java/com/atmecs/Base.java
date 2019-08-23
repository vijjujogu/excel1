package com.atmecs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;



public class Base {
	
public static WebDriver driver;
	
	/**
	 * logic for initializing browser
	 */
	//@Test
	public static void initialization() {
		
		String browserName =ReadPropertyFile.readProperty(Constants.configpath ,"browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",Constants.chromepath);
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FireFox")){
			System.setProperty("webdriver.gecko.driver",Constants.ffpath);	
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("IE")){
			System.setProperty("webdriver.ie.driver",Constants.iepath);	
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(ReadPropertyFile.readProperty(Constants.configpath ,"url"));
		
	}
}
