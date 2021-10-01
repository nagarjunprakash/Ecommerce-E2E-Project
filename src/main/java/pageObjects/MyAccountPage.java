package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import resources.base;
import utilities.ActionsClass;
import utilities.DropdownSelectResult;

public class MyAccountPage {

	public WebDriver driver;
	public DropdownSelectResult dp;
	public ActionsClass ac;

	By desktops=By.xpath("//a[.='Desktops']");
	By AllDropdownElements=By.xpath("//li[@class='dropdown open']//div[@class='dropdown-menu']/a | //li[@class='dropdown open']//div[@class='dropdown-inner']/ul/li ");
	
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		dp = new DropdownSelectResult(driver);
		ac = new ActionsClass(driver);
	}

	public WebElement desktops() {
		return driver.findElement(desktops);
	}

	public List<WebElement> AllDropdownElements() {
		
			return driver.findElements(AllDropdownElements);
		}
	}



