package com.automationpractice.WEB_Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.automationpractice.WEB_Tests.utilities.Utilities;

public class CartInfo extends PageBase {

	private Utilities u;
	private By itemCost = By.cssSelector("span[id='layer_cart_product_price']");
	private By continueShoppingButton =  By.cssSelector("span[class='continue btn btn-default button exclusive-medium']");
	private By popUp  = By.cssSelector("div[class='layer_cart_cart col-xs-12 col-md-6']");
	private By proceedToCheckoutBttn = By.cssSelector("a[class='btn btn-default button button-medium']");
	public static String CART_INFO_COST_1;
	public static String CART_INFO_COST_2;
	
	public CartInfo () { 
		if(u==null) {
			u=new Utilities();
		}
	}
	
	// wait for this pop-up page to load
	public void WaitForCartToLoad() {
		u.waitTillElementVisible(popUp, 50);
//		System.out.println("Done WaitForCartToLoad");
	}
	
	public void waitForPriceToLoad() {
		u.waitTillElementVisible(itemCost, 30);
	}
	
	public void ClickContinueShopping() {
		u.waitTillElementVisible(continueShoppingButton, 30);
		driver.findElement(continueShoppingButton).click();		
	}
	
	public String getPrice() {
//		Pages.QuickView().switchToQuickViewFrame();  // switch to quick view frame
		WebElement cost = driver.findElement(itemCost);
		String theCost = cost.getText();
		return theCost;
	}
	
	// gets a cost and assigns to global var ITEM_COST_1 for use in tests.
	public void getItem1Cost() {
		CART_INFO_COST_1 = getPrice();
	}
	
	// gets a cost and assigns to global var ITEM_COST_2 for use in tests.
		public void getItem2Cost() {
			CART_INFO_COST_2 = getPrice();
		}
	
	
	public void waitForProceedBttn() {
		u.waitTillElementVisible(proceedToCheckoutBttn, 30);
	}
	
	public void ClickProceedBttn () {
//		Pages.QuickView().switchToQuickViewFrame();  // switch to quick view frame
		WebElement proceed = driver.findElement(proceedToCheckoutBttn);
		proceed.click();
	}
} 