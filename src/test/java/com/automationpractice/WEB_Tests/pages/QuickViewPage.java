package com.automationpractice.WEB_Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.automationpractice.WEB_Tests.utilities.Utilities;

public class QuickViewPage extends PageBase{

	private By AddToCart = By.cssSelector("#add_to_cart > button");
	private By SelectAmount = By.cssSelector("input[id='quantity_wanted']");
	private By quickViewCost = By.cssSelector("span[id='our_price_display']");
	private By sizeDropDown = By.cssSelector("select[id='group_1']");
	private By frame  = By.xpath("//iframe[contains(@id,'fancybox-frame')]"); 
	private WebElement AddToCartButton;
	private String costItem1;
	private String costItem2;
	private Select select;
	private Utilities u;
	
	public QuickViewPage() {
		if(u==null) {
			u = new Utilities();
		}
	}

	//select item by text from the drop down
		public void selectSize(String dressSize) {
			String size = dressSize;
			waitForQuickPagetoLoad();
			switchToQuickViewFrame();
			WebElement sizeDropDownBox = driver.findElement(sizeDropDown);
			sizeDropDownBox.click();
			select = new Select(sizeDropDownBox);
			select.selectByValue(size);
		}
	
	public void switchToQuickViewFrame() {
		driver.switchTo().frame(driver.findElement(frame));
		
	}
	
	public void SetAmount(String amount) {
		String num = amount;
		WebElement amountTxtBox = driver.findElement(SelectAmount);
		amountTxtBox.sendKeys(num);
	}
		
	public void AddItemToCart() {
		AddToCartButton = driver.findElement(AddToCart);
		AddToCartButton.click();		
	}
	
	//wait for quick view page to load
	public void waitForQuickPagetoLoad() {
		u.waitTillElementVisible(frame, 50);
	}	
}
