package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Page;



public class HomePage extends Page {
	

	public void goToCustomers() {
		driver.findElement(By.cssSelector(".zh-customers")).click();
	}
	
	public void goToSupport() {
		driver.findElement(By.cssSelector(".zh-support")).click();
	}
	
	public void goToContactSales() {
		driver.findElement(By.cssSelector(".zh-contact")).click();
	}
	
	public LoginPage goToSignIn() {
		click("goToSignIn_CSS");
		return new LoginPage();
	}
	
	public void goToFreeSignUp() {
		driver.findElement(By.cssSelector(".zh-signup")).click();
	}
	
	public void goToFooterLink() {
		
	}
}

