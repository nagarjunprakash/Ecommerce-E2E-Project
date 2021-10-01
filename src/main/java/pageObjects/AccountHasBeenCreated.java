package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountHasBeenCreated {
	
	public WebDriver driver;
	
	
	By accountCreatedMessage=By.cssSelector("div[id='content'] h1");
	By continueButton=By.cssSelector(".btn.btn-primary");
	By accountLogoutText=By.cssSelector("div[id='content'] h1");
	By accountLogoutPageContinueButton=By.cssSelector(".btn.btn-primary");
	
	
	
	
	public AccountHasBeenCreated(WebDriver driver)
	{
		this.driver = driver;	
		
	}
	
	public WebElement accountCreatedMessage()
	{
		return driver.findElement(accountCreatedMessage);
	}
	
	public WebElement continueButton()
	{
		return driver.findElement(continueButton);
	}
	
	public WebElement accountLogoutText() 
	{
		return driver.findElement(accountLogoutText);
	}
	
	public WebElement accountLogoutPageContinueButton()
	{
		return driver.findElement(accountLogoutPageContinueButton);
	}
	
	

}
