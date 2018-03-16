package com.automationpractice.WEB_Tests.stepDefinitions;

import java.math.BigDecimal;

import org.junit.Assert;

import com.automationpractice.WEB_Tests.data.GlobalData;
import com.automationpractice.WEB_Tests.pages.AddressesPage;
import com.automationpractice.WEB_Tests.pages.Cart;
import com.automationpractice.WEB_Tests.pages.CartInfo;
import com.automationpractice.WEB_Tests.pages.LandingPage;
import com.automationpractice.WEB_Tests.pages.LoginPage;
import com.automationpractice.WEB_Tests.pages.MyAccountPage;
import com.automationpractice.WEB_Tests.pages.OrderConfirmationPage;
import com.automationpractice.WEB_Tests.pages.OrderHistoryPage;
import com.automationpractice.WEB_Tests.pages.OrderSummaryPage;
import com.automationpractice.WEB_Tests.pages.Pages;
import com.automationpractice.WEB_Tests.pages.PaymentMethodPage;
import com.automationpractice.WEB_Tests.pages.QuickViewPage;
import com.automationpractice.WEB_Tests.pages.ShippingPage;
import com.automationpractice.WEB_Tests.pages.Toolbar;
import com.automationpractice.WEB_Tests.pages.WomenPage;
import com.automationpractice.WEB_Tests.utilities.Utilities;

import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class PurchaseItem{

	private Utilities u;
//	private String url = GlobalData.URL;
//	private String dressSizeValue = DressSize.TWO;
	private String dressSizeValue = Utilities.DressSize.TWO;  
	
	private LandingPage land;
	private LoginPage login;
	private MyAccountPage myAccount;
	private WomenPage women;
	private QuickViewPage  quick;
	private CartInfo cartInfo;
	
	private String cost1;
	private String cost2;
	private String totalProducts;	
	
	private ShippingPage shipping;
	private AddressesPage addresses;
	private PaymentMethodPage payment;
	private OrderSummaryPage orderSummary;
	private OrderConfirmationPage	orderConfirmation;	
	private OrderHistoryPage orderHistory;
	private Cart cart;
	
	
	private String totalPrice;
	private Toolbar toolbar;
	
//	private String dressSizeValue = "2"; 
	
//	private String messageValue = "3";
	private String printedDressDetails = "Color : Orange, Size : M";	//trim out for just size if have time
	private String blouseDetails = "Color : Black, Size : S";			//trim out for just size if have time
	static String PURCHASE_DATE;
	private Scenario scenario;
	

	
	public PurchaseItem() {
		
		System.out.println("******* DEBUG  the value of dressizValue = "+dressSizeValue);
		if(u==null) {
		u = new Utilities(); 
			}
	}

	
	@Given("^the user user is logged into the site$")
		public void the_user_user_is_logged_into_the_site() throws Throwable {		      	
			Pages.ToolBarPage().ClickSignIn();
			Pages.Login().Login(GlobalData.EMAIL, GlobalData.PASSWORD);
		}		
		
		@When("^the user changes the size of an item$")
		public void the_user_changes_the_size_of_an_item() throws Throwable {
			Pages.MyAccountPage().WaitForMyAccountPageToLoad();
			Pages.MyAccountPage().ClickWomenButton();
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
//			 Boolean figuresAreCorrect = false;
			 Boolean Prod1SizeIsCorrect = false;
			 Boolean prod2SizeIsCorrect = false;
			 cart = u.getCart(cart);
			 
//			 confirm that the items are of the size you selected
			 String details1 = cart.getProduct1Details();    
			 String details2 = cart.getProduct2Details();
			 Prod1SizeIsCorrect = details1.equalsIgnoreCase(printedDressDetails);
			 prod2SizeIsCorrect = details2.equalsIgnoreCase(blouseDetails);
			
			 Assert.assertTrue(Prod1SizeIsCorrect);
			 Assert.assertTrue(prod2SizeIsCorrect);
			 
			 Pages.CartPage().getProductOneCost();  //assigned in page
			 // compare item2 prices
			 Pages.CartPage().getProductTwoCost(); //assigned in page

			 Assert.assertTrue(Pages.CartPage().comparePrices(Cart.CART_PRODUCT_ONE_PRICE,CartInfo.CART_INFO_COST_1)); 
			 Assert.assertTrue(Pages.CartPage().comparePrices(Cart.CART_PRODUCT_TWO_PRICE,CartInfo.CART_INFO_COST_2));
			 			 
//			 Total Products is the sum of the two items
			 totalProducts = cart.getTotalProducts();
			 
			 // sum the cart info prices     *************** MOVE All the calcs to utility class or similar - sub class in utility maybe?
//			 BigDecimal SummedCosts = u.sumTwoDollarAmounts(cost1, cost2);
			
			 BigDecimal SummedCosts = u.sumTwoDollarAmounts(CartInfo.CART_INFO_COST_1, CartInfo.CART_INFO_COST_2);
			 String strSummedCosts = SummedCosts.toString();
			 Boolean totalCostisCorrect = strSummedCosts.equalsIgnoreCase(totalProducts);
			 
			 
			 Assert.assertTrue(totalCostisCorrect);
			 
//			 ‘Total’ (subTotal) equals the Total Products + Shipping  
			 String subTotal = cart.getTotalPreTax();
			 String shipping = cart.getTotalShipping();
			 BigDecimal totalPlusShipping = u.sumTwoDollarAmounts(totalProducts, shipping);
			 String strTotalProductsPlusShipping = totalPlusShipping.toString();
			 Boolean subTotalEqualsProdusctsPlusShipping = strTotalProductsPlusShipping.equalsIgnoreCase(subTotal);
			 Assert.assertTrue(subTotalEqualsProdusctsPlusShipping);
			   								
		}
		
		@And  ("^the user can purchase the items$")
		public void the_user_can_purchase_the_items() {
		
				u.scrollDown();
				cart.clickProceedToCheckout();
				
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
				PURCHASE_DATE = u.getDate();				
				toolbar = u.getToolbar(toolbar);
				toolbar.ClickSignOut();
		}
		
}	
