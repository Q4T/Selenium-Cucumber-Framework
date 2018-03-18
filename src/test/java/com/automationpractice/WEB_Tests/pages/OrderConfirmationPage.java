package com.automationpractice.WEB_Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;	

public class OrderConfirmationPage extends PageBase {

	private By backToOrders   = By.cssSelector("a[class='button-exclusive btn btn-default']"); 
//	private By item1Date = By.cssSelector("//table/tbody/tr/td[2]");   // to be used to check the correct date of items
	
	public OrderConfirmationPage() {
		
	}
	
	public void clickBackToOrders(WebDriver driver) {
		WebElement goToOrders = driver.findElement(backToOrders);
		goToOrders.click();
	}	
}
