package com.automationpractice.WEB_Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Cart extends PageBase {

	String cellContents;

	private By totalProducts = By.xpath("//tfoot/tr/td[3]");										
	private By totalShipping = By.xpath("//tfoot/tr[3]/td[2]");
	private By totalPreTax = By.xpath("//tfoot/tr[5]/td[2]");
	private By totalTax = By.xpath("//tfoot/tr[6]/td[2]");
	private By grandTotal = By.xpath("//tfoot/tr[7]/td[2]/span");
	private By TotalCost = By.cssSelector("td[id='total_product']");
	private By cartCost1 = By.xpath("//tbody/tr[1]/td[4]/span/span");
	private By cartCost2 = By.xpath("//tbody/tr[2]/td[4]/span/span");
	private By cartProductSize1  = By.xpath("//tbody/tr[1]/td[2]//small[2]/a");  // looks like hard coding of the product ?
	private By cartProductSize2 =  By.xpath("//tbody/tr[2]/td[2]//small[2]/a");
	private By printedDressOrangeSize = By.xpath("//tbody/tr[1]/td[2]//small[2]/a");
	private By blouseSize = By.xpath("//tbody/tr[2]/td[2]//small[2]/a");
	
	
	private By proceedToCheckoutBttn = By.cssSelector("a[class='button btn btn-default standard-checkout button-medium']");
//	public static String  CART_PRODUCT_ONE_PRICE;
//	public static String  CART_PRODUCT_TWO_PRICE;
	public static String  itemOneCost;
	public static String  itemTwoCost;
	public static String totalProductCost;
	public static String printedDressOrange_Size = null;
	public static String blouse_Size  = null;
	
	
	
	public void clickProceedToCheckout() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("javascript:window.scrollBy(0,600)");
		System.out.println("scrolled down");
		u.waitTillElementVisible(proceedToCheckoutBttn, 20);
		WebElement proceed = driver.findElement(proceedToCheckoutBttn);
		proceed.click();
	}
	
	public String getTotalPrice() {
		WebElement cost = driver.findElement(TotalCost);
		String Totalprice = cost.getText();
		return Totalprice;		
	}
	
	public void waitForPageToLoad() {
		u.waitTillElementVisible(TotalCost, 30);
	}
	
	
	
	//*****************************************************************************  WORKING HERE
	
	public boolean compareProductSizes(String product1Size, String product2Size) {
		boolean x = product1Size.equalsIgnoreCase(product2Size);
		return x;
	}
	
	
	public String getOrangeDressSize() {
		String prodDetails = driver.findElement(printedDressOrangeSize).getText();
		printedDressOrange_Size = getSizeFromDetails(prodDetails);
		return printedDressOrange_Size;
	}
	
	
	private String getSizeFromDetails(String itemDetails) {
		String[] tokens = itemDetails.split("[^\\p{Alpha}]+");   //The second + at the end of the RegEx accounts for situations where you may have more than one consecutive non-alphabetic character that would otherwise split around an empty string token
		String iTemsize = tokens[3];
		return iTemsize;
	}
	
	public String getBlouseSize() {
		String prodDetails = driver.findElement(blouseSize).getText();
		blouse_Size = getSizeFromDetails(prodDetails);
		return blouse_Size;
	}
	
	

	
	
	//*****************************************************************************
	
	public String getProduct2Details() {      
		String prod2Details = driver.findElement(cartProductSize2).getText();
		return prod2Details;
	}
	
	
	// compares as strings
	public boolean comparePrices(String item1, String item2) {
		boolean result = compareProductDetails(item1,item2);
		return result;	
	}
	
	
	public Boolean compareProductDetails(String expectedText, String capturedText ) {
		String exp = expectedText;
		String cap = capturedText;
		Boolean txtAreTheSame = false;
//		System.out.println("expected txt is "+exp);
		txtAreTheSame = cap.equalsIgnoreCase(exp);               
		return txtAreTheSame;
	}
	
	public String CaptureProductDetails(By locator) {     
		By loc = locator;
		WebElement element = driver.findElement(loc);
		String capturedText = element.getText();
		return capturedText;
	}
	
	
	public void getProductOneCost() {
//		return CaptureProductDetails (cartCost1);
//		CART_PRODUCT_ONE_PRICE = CaptureProductDetails (cartCost1);
		itemOneCost = CaptureProductDetails (cartCost1);
	}
		
		public void getProductTwoCost() {
//			return CaptureProductDetails (cartCost2);
//			CART_PRODUCT_TWO_PRICE = CaptureProductDetails (cartCost2);
			itemTwoCost = CaptureProductDetails (cartCost2);
			
	}
	
	public String getTotalShipping() {
		return CaptureProductDetails (totalShipping);
	}
			
	public String getTotalProducts() {
		 String value = CaptureProductDetails (totalProducts);
		value = u.removeDollarSign(value); 
		return value;
	}
	
	public String getTotalPreTax() {
		String value = CaptureProductDetails (totalPreTax);
		value = u.removeDollarSign(value);
		return value;
	}
	
	public String getTax() {
		return CaptureProductDetails (totalTax);	}
	
	
	public String getGrandTotal() {
		return CaptureProductDetails (grandTotal);
	}
	
	
	public void sizeAsExpected(String size) {
		Boolean sizeisCorrect = false;
		
		
	}
	
	
	
	
	
	
	
	
}
