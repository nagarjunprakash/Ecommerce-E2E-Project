package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownSelectResult {
	
	WebDriver driver;
	
	public DropdownSelectResult(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void  dropdownSelectResultAutosugestion(String option,List<WebElement> allsuggestions) 
	{
		
		for(int i=0;i<allsuggestions.size();i++)
		{
			if(allsuggestions.get(i).getText().contains(option))
			{
				allsuggestions.get(i).click();
				break;
				
			}
		
		}
		
	}
	
	
	public void  dropdownSelectclass(String optiontoselect,WebElement dropdownelement)
	{
		Select UserroleDropdown = new Select(dropdownelement);
		List<WebElement> alloptions=UserroleDropdown.getOptions();
		
		for(int i=0;i<alloptions.size();i++)
		{
			if(alloptions.get(i).getText().contains(optiontoselect))
			{
				alloptions.get(i).click();
			}
			
			
		}
	
	}
	

}
