package TestAutoation;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;


public class HomePage extends Base {
	
	@BeforeTest
	public void initializer() throws IOException {
		driver = initializeDriver();
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
	}
	
	
	@Test(dataProvider = "getData")
	public void LoginIbulum(String username, String password) throws IOException {
		
		//driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		
		LoginPage lip = new LoginPage(driver);
		lip.getUserName().sendKeys(username);
		lip.getPassword().sendKeys(password);
		lip.getLogin().click();	
	
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		//with correct info
		data[0][0] = "joseph.shaya@shayasolions.se";
		data[0][1] = "foobar";
		//with wrong info
		data[1][0] = "joseph.shshayasolutions.se";
		data[1][1] = "fbar";
		return data;
	}

}
