package com.automationpractice.WEB_Tests.stepDefinitions;

import java.math.BigDecimal;
import org.junit.Assert;
import com.automationpractice.WEB_Tests.data.GlobalData;
import com.automationpractice.WEB_Tests.pages.AddressesPage;
import com.automationpractice.WEB_Tests.pages.Cart;
import com.automationpractice.WEB_Tests.pages.CartInfo;
import com.automationpractice.WEB_Tests.pages.OrderSummaryPage;
import com.automationpractice.WEB_Tests.pages.Pages;
import com.automationpractice.WEB_Tests.pages.PaymentMethodPage;
import com.automationpractice.WEB_Tests.pages.ShippingPage;
import com.automationpractice.WEB_Tests.pages.Toolbar;
import com.automationpractice.WEB_Tests.utilities.Utilities;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class PurchaseItem{

	private Utilities u;
	private String dressSizeValue = Utilities.DressSize.TWO;  
	

//	private String cost1;
//	private String cost2;
	private String totalProducts;	
	
	private ShippingPage shipping;
	private AddressesPage addresses;
	private PaymentMethodPage payment;
	private OrderSummaryPage orderSummary;
	private Cart cart;
	

//	private String totalPrice;
	private Toolbar toolbar;
	
//	private String dressSizeValue = "2"; 
	
//	private String messageValue = "3";
//	private String printedDressDetails = "Color : Orange, Size : M";	//All detail of products needs moving into, where,  product classes?
//	private String blouseDetails = "Color : Black, Size : S";			//All detail of products needs moving into, where,  product classes?
	 
	final static String ITEM_ONE_SIZE = "M";    //  read in from data files or put in cucumber data table 
	final static String ITEM_TWO_SIZE = "S";	//  read in from data files or put in cucumber data table 
	final static String ItemOne = "printedDressOrange";
	final static String ItemTwo = "blouse";
	private String CapturedSize;
	public static String purchaseDate;       // what is this for?
	
	
	public PurchaseItem() {
		
		System.out.println("******* DEBUG  the value of dressizValue = "+dressSizeValue);
		if(u==null) {
		u = new Utilities(); 
			}
	}

	
	@Given("^the user user is logged into the site$")
		public void the_user_user_is_logged_into_the_site() throws Throwable {		      	
			Pages.ToolBarPage().ClickSignIn();
			Pages.login().Login(GlobalData.EMAIL, GlobalData.PASSWORD);
		}		
		
		@When("^the user changes the size of an item$")
		public void the_user_changes_the_size_of_an_item() throws Throwable {
			Pages.myAccountPage().WaitForMyAccountPageToLoad();
			Pages.myAccountPage().ClickWomenButton();
			Pages.Women().selectStripedTopDress();
			Pages.QuickView().selectSize(dressSizeValue); 
	
		}
		
		@When("^adds it to their basket$")
		public void adds_it_to_their_basket() throws Throwable {
			Pages.QuickView().AddItemToCart();
			Pages.CartInfoPage().waitForPriceToLoad();
			Pages.CartInfoPage().getItem1Cost();
//			cost1 = Pages.CartInfoPage().getPrice();
			Pages.CartInfoPage().ClickContinueShopping();
		}
		
		@And  ("^adds another item to the basket$")
		public void adds_another_item_to_the_basket()  throws Throwable{
			Pages.Women().selectBlouse();
			Pages.QuickView().waitForQuickPagetoLoad();
			Pages.QuickView().switchToQuickViewFrame();
			Pages.QuickView().AddItemToCart();
			Pages.CartInfoPage().waitForPriceToLoad();
			
			Pages.CartInfoPage().getItem2Cost();
//			cost2 = Pages.CartInfoPage().getPrice();
			Pages.CartInfoPage().waitForProceedBttn();
			Pages.CartInfoPage().ClickProceedBttn();
		}
		
		@Then ("^the sizes and cost calculations are correct$")
		public void the_sizes_and_cost_calculations_are_correct() throws Throwable {
			
			 CapturedSize = Pages.CartPage().getOrangeDressSize();
			 Assert.assertTrue(Pages.CartPage().compareProductSizes(CapturedSize, ITEM_ONE_SIZE));
			 
			 CapturedSize = Pages.CartPage().getBlouseSize();
			 Assert.assertTrue(Pages.CartPage().compareProductSizes(CapturedSize, ITEM_TWO_SIZE));
		
			 
			 Pages.CartPage().getProductOneCost();  //assigned in page
			 // compare item2 prices
			 Pages.CartPage().getProductTwoCost(); //assigned in page

			 Assert.assertTrue(Pages.CartPage().comparePrices(Cart.itemOneCost,CartInfo.itemOneInfoCost)); 
			 Assert.assertTrue(Pages.CartPage().comparePrices(Cart.itemTwoCost,CartInfo.itemTwoInfoCost));
			 			 
//			 Total Products is the sum of the two items
//			 totalProducts = cart.getTotalProducts();
			 totalProducts = Pages.CartPage().getTotalProducts();
			 
			 // sum the cart info prices     *************** MOVE All the calcs to utility class or similar - sub class in utility maybe?
//			 BigDecimal SummedCosts = u.sumTwoDollarAmounts(cost1, cost2);
			
			 BigDecimal SummedCosts = u.sumTwoDollarAmounts(CartInfo.itemOneInfoCost, CartInfo.itemTwoInfoCost);
			 String strSummedCosts = SummedCosts.toString();
			 Boolean totalCostisCorrect = strSummedCosts.equalsIgnoreCase(totalProducts);
			
			 Assert.assertTrue(totalCostisCorrect);
			 
//			 ‘Total’ (subTotal) equals the Total Products + Shipping  
//			 String subTotal = cart.getTotalPreTax();
			 String subTotal = Pages.CartPage().getTotalPreTax();
			 String shipping = Pages.CartPage().getTotalShipping();
			 BigDecimal totalPlusShipping = u.sumTwoDollarAmounts(totalProducts, shipping);
			 String strTotalProductsPlusShipping = totalPlusShipping.toString();
			 Boolean subTotalEqualsProdusctsPlusShipping = strTotalProductsPlusShipping.equalsIgnoreCase(subTotal);
			 Assert.assertTrue(subTotalEqualsProdusctsPlusShipping);
			   								
		}
		
		@And  ("^the user can purchase the items$")
		public void the_user_can_purchase_the_items() {
		
			
//			
				Pages.CartPage().clickProceedToCheckout();
				
				addresses = u.getAdressesPage(addresses);

				u.scrollToBottomofPage();
				addresses.clickProceedToCheckoutBttn();
			
				shipping = u.getShippingPage(shipping);

				u.scrollToBottomofPage();
				shipping.checkTermsOfService();
				shipping.clickProceedToCheckoutBttn();
				
				payment = u.getPaymentMethodPage(payment );
				payment.clickPaymentMethodPage();
						 
				orderSummary = u.getOrderSummaryPage(orderSummary);
				u.scrollToBottomofPage();
				orderSummary.clickconfirmOrderBttn();
				
				// capture date
				purchaseDate = u.getDate();				
				toolbar = u.getToolbar(toolbar);
				toolbar.ClickSignOut();
		}
		
}	
