package com.automationpractice.WEB_Tests.utilities;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import com.automationpractice.WEB_Tests.data.GlobalData;

import com.automationpractice.WEB_Tests.pages.*;

public class Utilities extends PageBase{
	

private LandingPage la;
private LoginPage log;
private CartInfo cartInformation;
private MyAccountPage theAccountPage;
private Cart thecart;
//private AddressesPage addPage;
//private ShippingPage shipping;
private PaymentMethodPage pay;
private OrderSummaryPage orderSum;
private OrderConfirmationPage orderConfirmation;
private Toolbar tool;
private OrderHistoryPage orderHistory;
private Select select;


	
	public static void TestSetUp( ) {
		String url = GlobalData.URL;
		PageBase.initialiseUtility();
		PageBase.initialiseDriver();
		driver.get(url);
		driver.manage().window().maximize();    
		System.out.println("Test Starting *********");
	}
	
	
	public void scrollToBottomofPage() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("javascript:window.scrollTo(0,document.body.scrollHeight)");
	}
	
	
//	public WebDriver getDriver(WebDriver drive) {
//		driver = drive;
//		if (driver==null) {
//			driver = DriverFactory.getDriver();
//		}
//		return driver;
//	}
	
	
	public OrderHistoryPage getOrderHistoryPage() {
		if (orderHistory==null) {
			orderHistory = new OrderHistoryPage();
		}
		return orderHistory;
	}
	
	
	public OrderConfirmationPage getOderConfirmationPage(OrderConfirmationPage confirm) {
		orderConfirmation = confirm;
		if(orderConfirmation==null) {
			orderConfirmation = new OrderConfirmationPage();
		}
		return orderConfirmation;
	}
	
	
	public OrderSummaryPage getOrderSummaryPage(OrderSummaryPage order) {
		orderSum = order;
		if(orderSum==null) {
			orderSum = new OrderSummaryPage();
		}
		return orderSum;	
	}
	
	
	public LandingPage getLandingPage(LandingPage land) {
		la = land;
		if(la==null) {
			la = new LandingPage();	
		}
		return la;
	}
	
	
	public LoginPage getLoginPage(LoginPage login) {
		log = login;
		if(log==null) {
			log = new LoginPage();
		}
		return log;	
	}
	
	public AddressesPage getAdressesPage(AddressesPage addPage ) {
		if (addPage==null) {
			addPage = new AddressesPage ();
		}
		return addPage;
	}
	
	public ShippingPage getShippingPage(ShippingPage shipping) {
		if(shipping==null) {
			shipping = new ShippingPage();
		}
		return shipping;
	}
	
	
	public CartInfo getCartInfo(CartInfo cartInfo) {
		cartInformation= cartInfo;
		if(cartInformation==null) {
			cartInformation = new CartInfo();
		}
		return cartInformation;
	}
	
	
	public MyAccountPage getMyAccount (MyAccountPage account) {
		theAccountPage = account;
		if(theAccountPage==null) {
			theAccountPage = new  MyAccountPage();
		}
		return theAccountPage;
	}
	
	
	public Cart getCart(Cart cart) {
		thecart = cart;
				if(thecart==null) {
					thecart =  new Cart();
				}
				return thecart;
	}
	
	public QuickViewPage getQuickViewPage (QuickViewPage quick) {
		QuickViewPage q = quick;
		if(q==null) {
			q = new QuickViewPage();
		}
		return q;
	}
	
	public WomenPage getWomenPage (WomenPage women) {
		WomenPage w = women;
		if(w==null) {
			w = new WomenPage();
		}
		return w;
	}
	
	public PaymentMethodPage getPaymentMethodPage(PaymentMethodPage payment) {
		 pay = payment;
		 if(pay==null) {
			 pay = new PaymentMethodPage();
		 }
		return pay;
	}
	
	
	public Toolbar getToolbar(Toolbar toolbar) {
		tool = toolbar;
		if(tool==null) {
			tool = new Toolbar();
		}
		return tool;
	}
	
	public WebDriver suiteSetUp(String URL) {
		// set  browser type here - I want it to be assignable at test suite level
		String url = URL;	
		if(driver==null) {
				driver = DriverFactory.getDriver();				
			}
			driver.get(url);						
			driver.manage().window().maximize();   
			System.out.println("Test Suite Starting *********");
			return driver;
	}
		
	
	public void embedScreenshot(Scenario scenario) throws Exception {

	    if (scenario.isFailed()) {
	        try {
	            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            String testName = scenario.getName();
	            scenario.embed(screenshot, "image/png");
	            scenario.write(testName);
	        } catch (WebDriverException wde) {
	            System.err.println(wde.getMessage());
	        } catch (ClassCastException cce) {
	        	System.err.println(cce.getMessage());
//	            cce.printStackTrace();
	        	}
	        }
	    }
	
		
	public static void testTearDown(){
		driver.close();
		driver.quit();
		System.out.println("Test Ending *********");
	}
	
	
	public void suiteTearDown(WebDriver driver) {
		driver.quit();
		driver.close();
		System.out.println("End of Test Suite**********");
	}
	
	public void goToUrl(WebDriver driver) {
			driver.get(GlobalData.URL);
	}
	
	
	public void waitTillElementVisible(By locator, int duration){
//		WebDriverWait wait = new WebDriverWait(driver, duration);
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		

	}
	
	
	public String removeDollarSign(String Value) {
		String val = Value;
		val = val.replace("$","");
		return val;
	}
	
	
	// accepts 2 $amounts as strings and returns a dollar amount as a bigDecimal
	public BigDecimal sumTwoDollarAmounts(String item1, String item2) {
		String itemOne = item1;
		String itemTwo =item2;
		itemOne = removeDollarSign(itemOne);
		itemTwo = removeDollarSign(itemTwo);
		//convert to BigDecimal
		BigDecimal BigItemOne = new BigDecimal (itemOne);
		BigDecimal BigItemTwo = new BigDecimal(itemTwo);
		return BigItemOne.add(BigItemTwo);
	}
	
	public boolean compareProductCosts(String prodCost1,String prodCost2){
		return prodCost1.equalsIgnoreCase(prodCost2);
	}
	
	public void scrollDown() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("javascript:window.scrollBy(350,500)");
	}
	
	
	public void scrollUp() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("javascript:window.scrollBy(350,500)");
//		je.executeScript("javascript:window.scrollTo(0,document.body.scrollTop)");
//		je.executeScript("javascript:window.scrollTo(0,document.body.scrollHeight)");
	}
		
	
	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String justDate= dateFormat.format(date);
		System.out.println("Current date is: --- "+justDate);	
		return justDate;
	} 
	
	
	public boolean retryingFindSelect(By locator, String value) {
        boolean result = false;
        int attempts = 0;
        String val = value;
        By loc = locator;
        WebElement dropDown = driver.findElement(loc);
        select = new Select(dropDown);
        while(attempts < 5) {
            try {
            	select.selectByValue(val);        
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
	}
	
	
	public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 5) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
	}
	
	// change this so that we have a method for each size to call that has the size as part of implementation
	public class DressSize {
		
		public static final String ONE = "1";
		public static final String TWO = "2";
		public static final String THREE = "3";

}
	
	
	
	
	
	
	
	
	
}	
