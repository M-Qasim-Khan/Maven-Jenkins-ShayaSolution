package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestAutoation.Base;

public class CompanyInfoPage extends Base {
	
	public static WebDriver driver;
	
	By companies = By.cssSelector("body > div > div > nav > div > ul > li:nth-child(2) > a");
	By editlink = By.xpath("/html/body/div/div/main/div[2]/table/tbody/tr[1]/td[9]/a[1]");
	By citytextfield = By.xpath("//input[@id='City']");
	By savebutton = By.xpath("//input[@class='btn btn-default']");
	
	public CompanyInfoPage(WebDriver driver) {
		this.driver = driver;
	}	
	
	public WebElement getCompanies() {		
		return driver.findElement(companies);		
	}
	
	public WebElement getEditLink() {		
		return driver.findElement(editlink);		
	}
	
	public WebElement getCityTextField() {		
		return driver.findElement(citytextfield);		
	}
	
	public WebElement getSaveButton() {		
		return driver.findElement(savebutton);		
	}

}
