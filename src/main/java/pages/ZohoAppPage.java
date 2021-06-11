package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



import base.Page;
import crm.pages.CRMHomePage;


public class ZohoAppPage extends Page {

	public void goToBooks() {
		driver.findElement(By.cssSelector("div:nth-of-type(1) > .tc")).click();
	}

	public void goToCalendar() {
		driver.findElement(By.cssSelector("div:nth-of-type(2) > .tc")).click();
	}

	public void goToCampaigns() {
		driver.findElement(By.cssSelector(".ea-app-container .zl-expand:nth-child(3) .tc")).click();
	}
	
	public void goToCliq() {
		driver.findElement(By.cssSelector("div:nth-of-type(4) > .tc")).click();
	}
	
	public CRMHomePage goToCRM() {
		driver.findElement(By.cssSelector("div:nth-of-type(6) > .tc")).click();
		/*WebElement companyName = driver.findElement(By.cssSelector("input#orgName"));
		if(companyName.isDisplayed()) {
		companyName.sendKeys("Mes Petits Filous");
		driver.findElement(By.cssSelector("input#orgPhone")).sendKeys("07875919875");
		driver.findElement(By.cssSelector("[value='Get Started\\!']")).click();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.cssSelector("[click='crm-home-blankpage \\=\\> skiptoHome\\(\\)']")).click();
		}
		*/
		return new CRMHomePage();
	}
}
