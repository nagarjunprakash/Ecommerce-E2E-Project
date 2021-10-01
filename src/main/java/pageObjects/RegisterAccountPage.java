package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterAccountPage {

	public WebDriver driver;

	public RegisterAccountPage(WebDriver driver) {
		this.driver = driver;

	}

	By firstName=By.id("input-firstname");
	By lastName=By.id("input-lastname");
	By email=By.id("input-email");
	By telephone=By.id("input-telephone");
	By password=By.id("input-password");
	By passwordConfirm=By.id("input-confirm");
	By newsletterSubscribeYes=By.xpath("(//input[@type='radio'])[2]");
	By newsletterSubscribeNo=By.xpath("(//input[@type='radio'])[3]");	
	By privacyPolicyCheckbox=By.name("agree");
	By registerPageContinueButton=By.cssSelector("input[value='Continue']");

	
	public void firstName(String text)
	{
	 driver.findElement(firstName).sendKeys(text);
	}
	
	public void lastName(String text)
	{
		 driver.findElement(lastName).sendKeys(text);
	}
	public void email(String text)
	{
		 driver.findElement(email).sendKeys(text);
	}
	public void telephone(String text)
	{
		driver.findElement(telephone).sendKeys(text);
	}
	
	public void password(String text)
	{
		driver.findElement(password).sendKeys(text);
	}
	
	public void passwordConfirm(String text)
	{
		 driver.findElement(passwordConfirm).sendKeys(text);
	}
	
	public WebElement newsletterSubscribeYes()
	{
		return driver.findElement(newsletterSubscribeYes);
	}
	
	
	public WebElement newsletterSubscribeNo()
	{
		return driver.findElement(newsletterSubscribeNo);
	}
	
	public WebElement privacyPolicyCheckbox()
	{
		return driver.findElement(privacyPolicyCheckbox);
	}
	
	public WebElement registerPageContinueButton()
	{
		return driver.findElement(registerPageContinueButton);
	}
	
	
	
	


}
