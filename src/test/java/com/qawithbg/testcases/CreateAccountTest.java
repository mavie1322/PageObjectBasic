package com.qawithbg.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Page;
import crm.accounts.pages.AccountsHomePage;
import crm.accounts.pages.CreateAccountsPage;
import pages.ZohoAppPage;
import utilities.Utilities;

public class CreateAccountTest {
	
	
	@Test(dataProviderClass=Utilities.class, dataProvider="dp")
	public void createAccountTest(Hashtable<String,String> data) throws InterruptedException {
		ZohoAppPage zoho = new ZohoAppPage();
		zoho.goToCRM();
		AccountsHomePage account = Page.menu.goToAccounts();
		CreateAccountsPage cap = account.gotoCreateAccounts();
		cap.createAccount(data.get("accountName"),data.get("accountSite"));
		
	}

}
