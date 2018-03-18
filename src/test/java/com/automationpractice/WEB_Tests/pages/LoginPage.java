package com.automationpractice.WEB_Tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automationpractice.WEB_Tests.data.GlobalData;


	
public class LoginPage extends PageBase{

	private  String emailAddress = GlobalData.EMAIL;
	private  String password = GlobalData.PASSWORD;
	private  By emailTxtBox = By.cssSelector("input[id='email']");
	private  By passTextBox = By.cssSelector("input[id='passwd']");
	private  By LoginBttn = By.cssSelector("button[id='SubmitLogin']");
	
	public LoginPage() {

	}
	
	public void EnterEmail(String email_Address) { 
		String em = email_Address;
		driver.findElement(emailTxtBox).sendKeys(em);
		
	}
	
	public void EnterPassword(String _password) {
		String pWord = _password;
		driver.findElement(passTextBox).sendKeys(pWord);
	}
	
	public void ClickSignIn() {
		driver.findElement(LoginBttn).click();	
	}
	
	public By GetEmailTextBox (){
		By emaltxt = emailTxtBox;
		return emaltxt;
	}
	
	public void WaitForLoginPageToLoad() {
		@SuppressWarnings("unused")
		WebElement wait = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(emailTxtBox));		
		}
	
	public void Login (String email_Adress,String password) {
		String email = email_Adress;
		String pwd = password;
		if (email.isEmpty()) {
			email = emailAddress;
		System.out.println("Email Address Cannot be empty");
		}
		if (pwd.isEmpty()) {
			pwd = password;
		System.out.println("Password Cannot be empty");
		}

		EnterEmail(emailAddress); 
		EnterPassword(password);
		ClickSignIn();
	}
	
	public void validLogin() {
		EnterEmail(emailAddress);  
		EnterPassword(password);
		ClickSignIn();
	}	
}
