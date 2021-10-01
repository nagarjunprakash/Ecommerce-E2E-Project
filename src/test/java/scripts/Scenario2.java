package scripts;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountHasBeenCreated;
import pageObjects.LoginPage;
import pageObjects.RegisterAccountPage;
import pageObjects.YourStorePage;
import resources.base;
import utilities.DropdownSelectResult;
import utilities.RandomStringIntegerUtils;

public class Scenario2 extends base {
	YourStorePage yp;
	LoginPage lp;

	@Test
	public void Scenario2_step1() {
		yp = new YourStorePage(driver);
		yp.myAccountDropdown().click();
		base.wait.until(ExpectedConditions.visibilityOfAllElements(yp.myAccountDropdownAlloptions()));
		yp.dp.dropdownSelectResultAutosugestion("Login", yp.myAccountDropdownAlloptions());

	}

	@Test
	public void Scenario2_step2() {
		base.wait.until(ExpectedConditions.titleContains("Account Login"));
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Account Login"));
		lp = new LoginPage(driver);
		lp.emailAddress().sendKeys(prop.getProperty("email"));
		lp.password().sendKeys(prop.getProperty("password"));
		lp.loginButton().click();

	}

	@Test
	public void Scenario2_step3() {
		base.wait.until(ExpectedConditions.titleContains("My Account"));
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("My Account"));

	}
}
