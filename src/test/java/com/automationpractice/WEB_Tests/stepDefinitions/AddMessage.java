package com.automationpractice.WEB_Tests.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.WEB_Tests.pages.*;
import com.automationpractice.WEB_Tests.utilities.Utilities;

//import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AddMessage {

//	private WebDriver driver;
	private Utilities u;
	private Toolbar tool;
	private LoginPage login;
	private MyAccountPage account;
	private OrderHistoryPage orders;
	private String WebDropDownValue = "3";
	private PurchaseItem purchaseItem;
	private String purchaseDate; 
	private String message = "\"Persistence is very important. You should not give up unless you are forced to give up. -- Elon Musk\"";

	public AddMessage() {
		if(u==null) {
			u = new Utilities();}
		if(purchaseItem==null) { 
			purchaseItem = new PurchaseItem();} 
	}
	
	@Given ("^there is a product in the order hisory$")
	public void there_is_a_product_in_the_order_history() {	
		tool = u.getToolbar(tool);
		tool.ClickSignIn();
		login = u.getLoginPage(login);
		login.validLogin();
		account = u.getMyAccount(account);
		account.ClickOrderHistoryBttn();
		purchaseDate = PurchaseItem.purchaseDate;       // must be better way to do this? 
		orders = u.getOrderHistoryPage();
		orders.selectProduct(purchaseDate);
	}
	
	@When ("^the user adds a message to a particular product ordered$")
	public void the_user_adds_a_message_to_a_particular_product_ordered() {
		orders.SelectMessageItem(WebDropDownValue);
		orders.WriteMessage(message);
		orders.clickSubmitButton();
		orders.VerifySuccessMsg();
	}
	
	
	@Then ("^the message will appear under messages$")
	public void the_message_will_appear_under_messages() {
		boolean flag = orders.ValidateMessage(message);
	    Assert.assertTrue(flag);
	}	
}
