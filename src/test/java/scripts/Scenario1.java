package scripts;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountHasBeenCreated;
import pageObjects.RegisterAccountPage;
import pageObjects.YourStorePage;
import resources.base;
import utilities.DropdownSelectResult;
import utilities.RandomStringIntegerUtils;

public class Scenario1 extends base {

	YourStorePage yp;
	RegisterAccountPage rp;
	AccountHasBeenCreated ap;
	String firstName=RandomStringIntegerUtils.randomString();
	String lastName=RandomStringIntegerUtils.randomString();
	String email=firstName+lastName+"@gmail.com";
	String telephone=RandomStringIntegerUtils.randomIntegerRtString();
	String password=RandomStringIntegerUtils.randomAlphaNumeric();
	String passwordConfirm=password;
	

	
	@Test
	public void Scenario1_step1() 
	{
		yp =new YourStorePage(driver);
		yp.myAccountDropdown().click();
		base.wait.until(ExpectedConditions.visibilityOfAllElements(yp.myAccountDropdownAlloptions()));
		yp.dp.dropdownSelectResultAutosugestion("Register",yp.myAccountDropdownAlloptions());
		
		}
	
	@Test
	public void Scenario1_step2() 
	{
		base.wait.until(ExpectedConditions.titleContains("Register Account"));
		rp=new RegisterAccountPage(driver);
		rp.firstName(firstName);
		rp.lastName(lastName);
		rp.email(email);
		rp.telephone(telephone);
		rp.password(password);
		rp.passwordConfirm(passwordConfirm);
		rp.privacyPolicyCheckbox().click();
		rp.registerPageContinueButton().click();
	}
	@Test
	public void Scenario1_step3() 
	{	
		ap=new AccountHasBeenCreated(driver);
		wait.until(ExpectedConditions.visibilityOf(ap.accountCreatedMessage()));
		ap.continueButton().click();
		
	}
	@Test
	public void Scenario1_step4() 
	{
		
		
		base.wait.until(ExpectedConditions.titleContains("My Account"));
		Assert.assertEquals(driver.getTitle(), "My Account");
	}
	@Test
	public void Scenario1_step5() 
	{
		yp.myAccountDropdown().click();
		base.wait.until(ExpectedConditions.visibilityOfAllElements(yp.myAccountDropdownAlloptions()));
		yp.dp.dropdownSelectResultAutosugestion("Logout",yp.myAccountDropdownAlloptions());
		wait.until(ExpectedConditions.visibilityOf(ap.accountLogoutText()));
		ap.accountLogoutPageContinueButton().click();
		
		
	}
	
	@Test
	public void Scenario1_step6() 
	{
		base.wait.until(ExpectedConditions.titleContains("Your Store"));
		Assert.assertEquals(driver.getTitle(), "Your Store");
	}
}

