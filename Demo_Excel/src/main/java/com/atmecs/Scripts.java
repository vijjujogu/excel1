package com.atmecs;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Scripts extends Base{

	@BeforeClass
	public void setUp() {
		 Base.initialization();
		}
	@DataProvider
	public Object[][] getExcelData()
	{
		Object[][] data = ExcelReading.getTestData("Sheet1");
		return data;
	}
	@Test(dataProvider="getExcelData",priority=1)
	public void selectProduct(String product, String color, String size, String quantity)
	{
		Helper.clickOnElement("click_on_search");
		Helper.sendkeysToElement("search_for_product",product);
		Helper.selectFromDropdown("select_color", color);
		Helper.selectFromDropdown("select_size", size);
		Helper.sendkeysToElement("select_quantity",quantity);
		//Helper.clickOnElement("click_on_cart");			
	}
	@Test(priority=2)
	public void clickOnCart()
	{
		Helper.clickOnElement("click_on_cart_total");
		double price1=Double.parseDouble(Helper.getTextOfElement("get_price_of_product1").substring(1));
		double price2=Double.parseDouble(Helper.getTextOfElement("get_price_of_product2").substring(1));
		double total=Double.parseDouble(Helper.getTextOfElement("get_total_amount").substring(1));
		double grandTotal=price1+price2;
		Assert.assertEquals(total, grandTotal,"grandtotal is verified");		
	}
	@Test(priority=3)
	public void getTableCount() {
		int count=Helper.getCountOfElement("get_numOfRows_inTable");
		System.out.println(count);
		Assert.assertEquals(count, 2,"products are added to cart");
	}
	
	
}
