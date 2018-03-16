package com.automationpractice.WEB_Tests.pages;

public class Pages {


		public static LoginPage Login() {
			LoginPage login = new LoginPage();
			return 	login;
		}
		
		public static AddressesPage Address() {
			 AddressesPage add = new AddressesPage();
			 return add;	
		}
		
		public static LandingPage Landing() {
			LandingPage land = new LandingPage();
			return land;
		}
		
		public static MyAccountPage MyAccountPage() {
			MyAccountPage account = new MyAccountPage();
			return account;		
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
	}
	
