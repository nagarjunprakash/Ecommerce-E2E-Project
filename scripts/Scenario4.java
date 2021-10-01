package scripts;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountHasBeenCreated;
import pageObjects.AllCategories;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegisterAccountPage;
import pageObjects.YourStorePage;
import resources.base;
import utilities.DropdownSelectResult;
import utilities.RandomStringIntegerUtils;

public class Scenario4 extends base {
	YourStorePage yp;
	LoginPage lp;
	MyAccountPage mp;
	AllCategories ap;

	@Test
	public void Scenario4_step1() {
		yp = new YourStorePage(driver);
		yp.myAccountDropdown().click();
		base.wait.until(ExpectedConditions.visibilityOfAllElements(yp.myAccountDropdownAlloptions()));
		yp.dp.dropdownSelectResultAutosugestion("Login", yp.myAccountDropdownAlloptions());

	}

	@Test
	public void Scenario4_step2() {
		base.wait.until(ExpectedConditions.titleContains("Account Login"));
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Account Login"));
		lp = new LoginPage(driver);
		lp.emailAddress().sendKeys(prop.getProperty("email"));
		lp.password().sendKeys(prop.getProperty("password"));
		lp.loginButton().click();

	}

	@Test
	public void Scenario4_step3() {
		captureScreenshotflag=true;
		base.wait.until(ExpectedConditions.titleContains("My Account"));
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("My Account"));

	}

	@Test
	public void Scenario4_step4() {
		mp = new MyAccountPage(driver);
		mp.ac.mouseoverClick(mp.desktops());
		mp.dp.dropdownSelectResultAutosugestion("Show All Desktops", mp.AllDropdownElements());

	}

	@Test
	public void Scenario4_step5() {
		captureScreenshotflag=true;
		ap = new AllCategories(driver);
		ap.listviewButton().click();	
		Assert.assertTrue(ap.listviewElements().size() >= 1, "List View is Selected");
		
	}

	@Test
	public void Scenario4_step6() {
		
		ap = new AllCategories(driver);
		ap.gridviewButton().click();
		Assert.assertTrue(ap.gridViewElements().size() >= 1, "Grid View is Selected");
		

	}
}
