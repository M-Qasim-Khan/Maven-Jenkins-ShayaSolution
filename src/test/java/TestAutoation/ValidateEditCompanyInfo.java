package TestAutoation;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CompanyInfoPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class ValidateEditCompanyInfo extends Base {
	
	@BeforeTest
	public void initializer() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
	}
	
	@Test	
	public void editCompanyInfo() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		
		LoginPage lip = new LoginPage(driver);
		lip.getUserName().sendKeys(prop.getProperty("username"));
		lip.getPassword().sendKeys(prop.getProperty("password"));
		lip.getLogin().click();	
		
		CompanyInfoPage cif = new CompanyInfoPage(driver);		
		cif.getCompanies().click();
		cif.getEditLink().click();
		cif.getCityTextField().clear();
		cif.getCityTextField().sendKeys(prop.getProperty("city"));
		cif.getSaveButton().click();
		
	}

}
