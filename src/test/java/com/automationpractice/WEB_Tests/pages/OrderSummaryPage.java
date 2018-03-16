package com.automationpractice.WEB_Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrderSummaryPage extends PageBase {

	private By confirmOrderBttn = By.cssSelector("button[class='button btn btn-default button-medium']") ;  
	
	public OrderSummaryPage () {
		
	}
	
	public void clickconfirmOrderBttn() {
		WebElement confirmOrder = driver.findElement(confirmOrderBttn);
		confirmOrder.click();	
	}	
}