package com.atmecs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Helper extends Base{

	public static void clickOnElement(String element)
	{
		String locator_value=ReadPropertyFile.readProperty(Constants.locator_path,element);
		driver.findElement(By.xpath(locator_value)).click();
	}
	public static void sendkeysToElement(String element,String valueToSend)
	{
		String locator_value=ReadPropertyFile.readProperty(Constants.locator_path,element);
		driver.findElement(By.xpath(locator_value)).clear();
		driver.findElement(By.xpath(locator_value)).sendKeys(valueToSend+Keys.ENTER);
	}
	public static void selectFromDropdown(String element,String valueToSelect)
	{
		String locator_value=ReadPropertyFile.readProperty(Constants.locator_path,element);
		Select dropdown = new Select(driver.findElement(By.xpath(locator_value)));
		dropdown.selectByVisibleText(valueToSelect);
	}
	public static String getTextOfElement(String element)
	{
		String locator_value=ReadPropertyFile.readProperty(Constants.locator_path,element);
		String text=driver.findElement(By.xpath(locator_value)).getText();
		return text;
	}
	public static int getCountOfElement(String element)
	{
		String locator_value=ReadPropertyFile.readProperty(Constants.locator_path,element);
		List<WebElement> count = driver.findElements(By.xpath(locator_value));
		 return count.size();
	}
}
