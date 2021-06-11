package crm.accounts.pages;

import org.openqa.selenium.By;

import base.Page;



public class CreateAccountsPage extends Page {

	public void createAccount(String accountName, String accountSite) throws InterruptedException {
		type("accName_CSS", accountName);
		Thread.sleep(1000);
		type("accSite_CSS", accountSite);
		//driver.findElement(By.cssSelector("[tabindex='7']")).sendKeys(accountName);
	}
	
	public void editPageLayout() {
		
	}
}
