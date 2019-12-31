package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By username = By.xpath("//*[@id=\"Email\"]");
	By password = By.xpath("//*[@id=\"Password\"]");
	By loginbutton = By.xpath("//*[@id=\"loginForm\"]/form/div[4]/div/input");
	By logoutbutton = By.xpath("//a[@class='btn btn-danger']");
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUserName() {

		return driver.findElement(username);

	}

	public WebElement getPassword() {

		return driver.findElement(password);

	}
	public WebElement getLogin() {

		return driver.findElement(loginbutton);

	}
	
	public WebElement getLogout() {

		return driver.findElement(logoutbutton);

	}
	
	

}
