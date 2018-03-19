package com.automationpractice.WEB_Tests.stepDefinitions;

import org.junit.Assert;
import com.automationpractice.WEB_Tests.pages.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {

	 @Given("^user has valid credentials$")
	 public static void UserLogin() {
		Pages.ToolBarPage().ClickSignIn();	
	 }
	 
	 @When ("^user logs in$")
	 public void UserLogsIn () {
		 Pages.login().validLogin();
	 }
	 
	 @Then("^user is taken to the landing page$")
	 public void UserIsOnLandingPage() {
		boolean logOutIsAvailable =  Pages.myAccountPage().logoutPresent();
		Assert.assertTrue(logOutIsAvailable); 
	 }
	
}