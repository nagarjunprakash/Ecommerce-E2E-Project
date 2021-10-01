package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import resources.base;
import utilities.DropdownSelectResult;

public class YourStorePage {

	public WebDriver driver;
	public DropdownSelectResult dp;

	By myAccountDropdown = By.xpath("//ul[@class='list-inline']/li[2]");
//	By myAccountDropdownAlloptions = By.cssSelector(".dropdown-menu.dropdown-menu-right li");
//	By myAccountDropdownAlloptions = By.xpath("//ul[@class='list-inline']/li[2]/ul/li");
	By myAccountDropdownAlloptions = By.cssSelector("li[class='dropdown open'] ul li");
	
	
	
	public YourStorePage(WebDriver driver) {
		this.driver = driver;
		dp = new DropdownSelectResult(driver);

	}

	public WebElement myAccountDropdown() {
		return driver.findElement(myAccountDropdown);
	}

	public List<WebElement> myAccountDropdownAlloptions() {
		
			return driver.findElements(myAccountDropdownAlloptions);
		}
	}

