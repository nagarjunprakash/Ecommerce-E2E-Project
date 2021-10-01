package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.DropdownSelectResult;

public class LoginPage {
	
	public WebDriver driver;
	public DropdownSelectResult dp;
	
	
	By emailAddress=By.id("input-email");
	By password=By.id("input-password");
	By forgotPassword=By.xpath("div[class='form-group'] a");
	By loginButton=By.cssSelector("input[value='Login']");
	By validationMesssage=By.cssSelector(".alert.alert-danger.alert-dismissible");
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		dp = new DropdownSelectResult(driver);

	}
	
	public WebElement emailAddress() {
		return driver.findElement(emailAddress);
	}
	
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement forgotPassword() {
		return driver.findElement(forgotPassword);
	}
	
	public WebElement loginButton() {
		return driver.findElement(loginButton);
	}
	
	public WebElement validationMesssage() {
		return driver.findElement(validationMesssage);
	}
	
	
	

}
