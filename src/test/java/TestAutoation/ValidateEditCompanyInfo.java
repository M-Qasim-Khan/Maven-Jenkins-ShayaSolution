package TestAutomation;

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
		
		LoginIbulum();		
		
		CompanyInfoPage cif = new CompanyInfoPage(driver);		
		cif.getCompanies().click();
		cif.getEditLink().click();
		cif.getCityTextField().clear();
		cif.getCityTextField().sendKeys(prop.getProperty("city"));
		cif.getSaveButton().click();
		
	}

}
