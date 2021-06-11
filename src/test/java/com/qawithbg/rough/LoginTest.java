package com.qawithbg.rough;

import base.Page;
import crm.accounts.pages.AccountsHomePage;
import crm.accounts.pages.CreateAccountsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ZohoAppPage;

public class LoginTest {
	public static void main(String[] args) {
		HomePage home = new HomePage();
		LoginPage login = home.goToSignIn();
		ZohoAppPage zoho = login.doLogin("babimbilyoness@gmail.com", "Markalek2015");
		zoho.goToCRM();
		AccountsHomePage account = Page.menu.goToAccounts();
		CreateAccountsPage cap = account.gotoCreateAccounts();
		
	}

}
