package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Page;



public class LoginPage extends Page {
	

	public ZohoAppPage doLogin(String username,String password) {
		type("email_CSS",username);
		click("clickBtn_CSS");
		type("password_CSS",password);
		click("signBtn_CSS");
		return new ZohoAppPage();	
	}
	
	public void goToForgotPassword() {
		driver.findElement(By.cssSelector("#forgotpassword [onclick]")).click();
	}
	
	public void goToSigninUsingGoogle() {
		driver.findElement(By.cssSelector("span[title='Sign in using Google']")).click();
	}
	
	public void goToSigninUsingMicrosoft() {
		driver.findElement(By.cssSelector("span[title='Sign in using Microsoft']  .fed_icon")).click();
	}
	
	public void goToSigninUsingLinkedin() {
		driver.findElement(By.cssSelector(".fed_icon.linked_fed_icon")).click();
	}
	
	public void goToSigninUsingFacebook() {
		driver.findElement(By.cssSelector(".fb_fedicon.fed_icon")).click();
	}
	
	public void goToSigninUsingTwitter() {
		driver.findElement(By.cssSelector("span[title='Sign in using Twitter']  .fed_icon")).click();
	}
	
	public void goToSigninUsingMore() {
		driver.findElement(By.cssSelector("span#showIDPs")).click();
	}
	
	public void goToSignupNow() {
		driver.findElement(By.cssSelector("div#signuplink > a")).click();
	}
}
