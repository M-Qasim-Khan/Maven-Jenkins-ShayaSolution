package TestAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\qasim\\eclipse-workspace\\ShayaSolution\\src\\main\\java\\TestAutomation\\datadriven.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty(prop.getProperty("key"), prop.getProperty("value"));
			driver = new ChromeDriver();
		}else {
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void getScreenShots(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("C:\\Users\\qasim\\eclipse-workspace\\test\\"+result+"screeshots.png"));
	}
	
	
	public void LoginIbulum() throws IOException{
		
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		
		LoginPage lip = new LoginPage(driver);
		lip.getUserName().sendKeys(prop.getProperty("username"));
		lip.getPassword().sendKeys(prop.getProperty("password"));
		lip.getLogin().click();	
		
	
	}
	
	

}
