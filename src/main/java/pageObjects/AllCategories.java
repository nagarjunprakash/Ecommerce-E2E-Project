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

public class AllCategories{

	public WebDriver driver;
	public DropdownSelectResult dp;
	public ActionsClass ac;

	By listviewButton=By.id("list-view");
	By gridviewButton=By.id("grid-view");
	By listviewElements=By.xpath("(//div[@class='product-layout product-list col-xs-12'])");
	By gridViewElements=By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']");
	
	
	
	public AllCategories(WebDriver driver) {
		this.driver = driver;
		dp = new DropdownSelectResult(driver);
		ac = new ActionsClass(driver);
	}

	public WebElement listviewButton() {
		return driver.findElement(listviewButton);
	}
	
	public WebElement gridviewButton() {
		return driver.findElement(gridviewButton);
	}
	
	

	public List<WebElement> listviewElements() {
		
			return driver.findElements(listviewElements);
		}
	
	public List<WebElement> gridViewElements() {
		
		return driver.findElements(gridViewElements);
	}
	}



