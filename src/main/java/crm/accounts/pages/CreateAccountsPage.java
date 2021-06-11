package crm.accounts.pages;

import org.openqa.selenium.By;

import base.Page;



public class CreateAccountsPage extends Page {

	public void createAccount(String accountName, String accountSite) {
		type("accName_CSS", accountName);
		type("accName_CSS", accountSite);
		//driver.findElement(By.cssSelector("[tabindex='7']")).sendKeys(accountName);
	}
	
	public void editPageLayout() {
		
	}
}
