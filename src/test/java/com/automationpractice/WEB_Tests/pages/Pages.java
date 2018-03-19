package com.automationpractice.WEB_Tests.pages;

// if we need the pages to be non-static we can just initialise the Pages page in the @beforeTest or setup hook.
public class Pages {

	public static MyAccountPage myAccountPage;
	public static LoginPage loginPage;
	public static AddressesPage addressPage;
	public static LandingPage landingPage;
//	public static rest need doing
//	public static
//	public static
//	public static
//	public static
//	public static
//	public static
//	public static
//	public static
//	public static
//	public static
//	public static
//	public static
//	public static

	
	
		public static LoginPage login() {
			if(loginPage==null) {
			LoginPage lo = new LoginPage();
			loginPage = lo;
			}
			return 	loginPage;
		}
		
		public static AddressesPage address() {
			if(addressPage==null) {
			 AddressesPage add = new AddressesPage();
			 addressPage = add;
			}
			 return addressPage;	
		}
		
		public static LandingPage Landing() {
			if(landingPage==null) {
				LandingPage land = new LandingPage();
				landingPage = land;
			}
			return landingPage;
		}
		
		public static MyAccountPage myAccountPage() {
			if (myAccountPage == null) {
			MyAccountPage account = new MyAccountPage();
			myAccountPage = account;
			}
			return myAccountPage;		
		}
		
		public static Toolbar ToolBarPage() {
			Toolbar tool = new Toolbar();
			return tool;
		}
		
		public static WomenPage Women() {
			WomenPage women = new WomenPage();
			return women;	
		}
		
		public static QuickViewPage QuickView() {
			QuickViewPage quick = new QuickViewPage();
			return quick;
		}
		
		public static CartInfo CartInfoPage() {
			CartInfo cart = new CartInfo();
			return cart;
		}
		
		public static Cart CartPage() {
			Cart cart = new Cart();
			return cart;
		}
		
		public static OrderConfirmationPage OrderConfirmationPage() {
			OrderConfirmationPage o = new OrderConfirmationPage();
			return o;	
		}
		
		public static OrderHistoryPage OrderHistoryPage() {
			OrderHistoryPage oh =  new OrderHistoryPage();
			return oh;
		}
		
		public static OrderSummaryPage OrderSummaryPage() {
			OrderSummaryPage os = new OrderSummaryPage();
				return os;	
		}
		
		public static PaymentMethodPage PaymentMethodPage() {
			PaymentMethodPage pm = new PaymentMethodPage();
			return pm;
		}
		
		public static ShippingPage ShippingPage() {
			ShippingPage sp = new ShippingPage();
			return sp;
		}
		
		
		
		
	}
	
