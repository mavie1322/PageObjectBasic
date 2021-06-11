package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import crm.accounts.pages.AccountsHomePage;



public class TopMenu {
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver) {
		this.driver = driver;
	}

	public void goToHome() {
		
	}
	
	public void goToLeads() {
		
	}

	public void goToContacts() {
		
	}
	
	public AccountsHomePage goToAccounts() {
		
		Page.click("Accounts_LINK");
		
		return new AccountsHomePage();
	}
	
	public void goToDeals() {
		
	}

	public void goToActivities() {
		
	}
	
	public void goToReports() {
		
	}

	public void goToAnalytics() {
		
	}
	
	public void goToProducts() {
		
	}
	 
	public void goToSearchModules() {
		
	}
	
	public void goToUpgradeEntrepriseTrial() {
		
	}
	
	public void goToSearch() {
		
	}
	
	public void goToSignals() {
		
	}
	
	public void goToLead() {
		
	}
	
	public void myAccount() {
		
	}

}
