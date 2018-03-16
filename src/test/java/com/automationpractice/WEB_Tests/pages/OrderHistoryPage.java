package com.automationpractice.WEB_Tests.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.WEB_Tests.utilities.Utilities;


public class OrderHistoryPage extends PageBase {
	private By WebTable = By.cssSelector("table[id='order-list']");
	private By Submitbuttom = By.cssSelector("button[name='submitMessage']");
	private By MessageDropDown = By.cssSelector("select[name='id_product']");
	private By messageTextBox = By.xpath("//textarea");
	private By SuccessMsg = By.cssSelector("p[class ='alert alert-success']");
	private By messagesTable = By.xpath("//div[@id='block-order-detail']/div[5]/table/tbody");      // ***this needs changing as selenium things this is the orders table and runs through that.
	private Utilities u;
	private Select select;	

	public OrderHistoryPage (){
		
		 if(u==null) {
			 u = new Utilities();
		 }
	}
	
	public void clickSubmitButton() {
		u.waitTillElementVisible(Submitbuttom, 30);
		u.retryingFindClick(Submitbuttom);		
	}
	
	public boolean VerifySuccessMsg() {
		boolean flag = false;
		u.waitTillElementVisible(SuccessMsg, 60);
		if (driver.findElement(SuccessMsg).isDisplayed()) {
			flag = true;
			System.out.println("The Success msg was displayed to say the message was entered");
		}
		return flag;
	}
	
	public void selectProduct(String date) {
		String purchaseDate = date;
		By TableRows = By.xpath("//table[@id='order-list']/tbody/tr");
	WebElement Webtable=driver.findElement(WebTable);
	List<WebElement> TotalRowCount=Webtable.findElements(TableRows);  
	int RowIndex=1;
	
	for(WebElement row:TotalRowCount){
	      List<WebElement> TotalColumnCount=row.findElements(By.xpath("td"));
	      int ColumnIndex=1;
	      for(WebElement col:TotalColumnCount){
	           String capturedText = col.getText();
	           // if the text = the date I want then concat the xpath and click the column to the left
	           if(capturedText.equalsIgnoreCase(purchaseDate)) {
	        	   driver.findElement(By.xpath("//tbody/tr[" + RowIndex + "]/td["+ (ColumnIndex-1) + "]")).click();  
	        	   break;
	           }
	           ColumnIndex=ColumnIndex+1;
	       }
	      RowIndex=RowIndex+1;
	 }	
}
	
	// by value
	public void SelectMessageItem(String WebDropDownValue) {
//		u.scrollDown();
		u.scrollToBottomofPage();
		String num = WebDropDownValue;	
		u.waitTillElementVisible(MessageDropDown, 20);
		u.retryingFindSelect(MessageDropDown, num);

	}		
				
	public void WriteMessage(String message) {
		String msg = message;
		WebElement TextBox = driver.findElement(messageTextBox);
		u.waitTillElementVisible(messageTextBox, 40);
			TextBox.sendKeys(msg);			
	}
			
//	messagesTable
	public boolean ValidateMessage(String message) {
		boolean flag = false;
		String msg = message;
		By TableRows = By.xpath("//div[@id='block-order-detail']/div[5]/table/tbody/tr");

	    u.waitTillElementVisible(messagesTable, 20);
		WebElement WebTable=driver.findElement(messagesTable);
		List<WebElement> TotalRowCount=WebTable.findElements(TableRows); 
//		System.out.println("No. of Rows in the WebTable: "+TotalRowCount.size());  
		int RowIndex=1;		
		
		for(WebElement row:TotalRowCount){
		      List<WebElement> TotalColumnCount=row.findElements(By.xpath("td"));
		      int ColumnIndex=1;
		      for(WebElement col:TotalColumnCount){
		           String capturedText = col.getText();
	
		           // if the text = the message the test passes
		           if(capturedText.equalsIgnoreCase(msg)) {
		        	   flag = true;
//		        	   System.out.println("Captured text = -- "+capturedText);
//			           System.out.println("Text as written = -- "+msg);
		        	   if (flag) {
		        		   Assert.assertTrue(flag);   
		        	   } 
		        	   break;
		           }
		           ColumnIndex=ColumnIndex+1;
		       }
		      RowIndex=RowIndex+1;
		 }
	return flag;	
	}						
}
