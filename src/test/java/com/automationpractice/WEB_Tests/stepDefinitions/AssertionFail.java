package com.automationpractice.WEB_Tests.stepDefinitions;

import org.junit.Assert;
import com.automationpractice.WEB_Tests.pages.LoginPage;
import com.automationpractice.WEB_Tests.pages.MyAccountPage;
import com.automationpractice.WEB_Tests.pages.OrderHistoryPage;
import com.automationpractice.WEB_Tests.pages.Toolbar;
import com.automationpractice.WEB_Tests.utilities.Utilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class AssertionFail {
	Utilities u;
	private LoginPage login;
	private Toolbar toolbar;
	private OrderHistoryPage orders;
	private String message = "This will cause the asertion to fail.";
	private boolean assertFlag;
	private MyAccountPage account;
	
	
	public  AssertionFail() {
//		driver = DriverFactory.getDriver();	
		if(u==null) {
			u = new Utilities(); 
			}
	}
	
	@Given("^there is an assertion fail$") 
	public void there_is_an_assertion_fail(){
		toolbar = u.getToolbar(toolbar);
		toolbar.ClickSignIn();
		login = u.getLoginPage(login);
		login.validLogin();
	}
	
	
	@When ("^the failure occurs$")
	public void the_failure_occurs() {
		account = u.getMyAccount(account);
		account.ClickOrderHistoryBttn();	
	}
		

	@Then ("^a screenshot is taken$")
	public void a_screenshot_is_taken() {
		orders = u.getOrderHistoryPage();
		Assert.fail();
	}
	
	
	
}
