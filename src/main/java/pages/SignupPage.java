package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.Page;



public class SignupPage extends Page {

	
	
	public void goHomePage() {
		driver.findElement(By.cssSelector(".logo")).click();
	}
	public void goToLogin() {
		driver.findElement(By.cssSelector("input#signupbtn")).click();
	}
	
	public void createAccount(String email, String password) {
		driver.findElement(By.cssSelector("input#emailfield")).sendKeys(email);
		driver.findElement(By.cssSelector("input#password")).sendKeys(password);
		driver.findElement(By.cssSelector("input#tos")).click();
		driver.findElement(By.cssSelector("input#signupbtn")).click();
	}
	
	public void changeCountry() {
		driver.findElement(By.cssSelector("#zip-countryname-change")).click();
	}
	
	public void seeTermsOfService() {
		driver.findElement(By.cssSelector("label > a:nth-of-type(1)")).click();
	}
	
	public void seePrivacyPolicy() {
		driver.findElement(By.cssSelector(".zrlink")).click();
	}
	
	public void signinUsingGoogle() {
		driver.findElement(By.cssSelector(".vi-google")).click();
	}
	
	public void signinUsingMicrosoft() {
		driver.findElement(By.cssSelector(".vi-office365")).click();
	}
}
