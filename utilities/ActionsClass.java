package utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
	WebDriver driver;
	 Actions act;

	public ActionsClass(WebDriver driver ){
		this.driver = driver;
	}
	
	public void mouseoverandselectoption(WebElement element, List<WebElement> options, String text) {

		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().contains(text)) {
				options.get(i).click();
				break;
			}

		}
	}

	public void mouseoverClick(WebElement element1) {
		Actions act = new Actions(driver);
	
			act.moveToElement(element1).click().build().perform();
		
		}
	
	
	public void mouseover(WebElement element1) {
		Actions act = new Actions(driver);
	
			act.moveToElement(element1).build().perform();
		
		}

	}

