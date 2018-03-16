package com.automationpractice.WEB_Tests.pages;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;   // this works fine. Don't understand the issue.
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.WEB_Tests.utilities.Utilities;


public class WomenPage extends PageBase{

	private Select select;
	private Utilities u;
	private BigDecimal BD;
	
	By womenPageHeader  = By.cssSelector("h1[class='page-heading product-listing']");
	By Blouse = By.cssSelector("a[class='quick-view'][http://automationpractice.com/index.php?id_product=2&controller=product']>span");
	By Hover_Blouse = By.cssSelector("img[class='replace-2x img-responsive'][src='http://automationpractice.com/img/p/7/7-home_default.jpg']");
	By Hover_PrintedDressStripyTop = By.cssSelector("img[src='http://automationpractice.com/img/p/8/8-home_default.jpg'][class='replace-2x img-responsive']"); 

	
	public WomenPage() {
//		PageFactory.initElements(driver,this);
	}
	
	public void clickProduct(By locator) {
		By loc = locator;
		driver.findElement(loc).click();
	}
	
	// Select striped dress for Quick View
	public void selectClothingItem(By locator) {
		By loc = locator;
		//scroll down
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("javascript:window.scrollBy(0,450)"); 
		//hover over & click
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(loc);
		action.moveToElement(we).moveToElement(driver.findElement(loc)).click().build().perform();	
		}
	
	
	public void selectStripedTopDress() {
		By item =  Hover_PrintedDressStripyTop;
		selectClothingItem(item);
	}
	
	public void selectBlouse() {
		By item = Hover_Blouse;
		selectClothingItem(item);
	}
	

	public void waitForPageToLoad() {
		if (u==null) {
		Utilities u = new Utilities();
		}
		u.waitTillElementVisible(womenPageHeader,30);
	}
}
