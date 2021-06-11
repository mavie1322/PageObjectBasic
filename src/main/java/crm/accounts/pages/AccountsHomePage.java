package crm.accounts.pages;

import base.Page;

public class AccountsHomePage extends Page{

	public CreateAccountsPage gotoCreateAccounts() {
		click("creatAcc_CSS");
		return new CreateAccountsPage();
	}
	
	public void gotoImportAccounts() {
		
	}
	
	public void gotoImportNotes() {
		
	}
}
