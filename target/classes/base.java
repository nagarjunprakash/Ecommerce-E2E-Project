package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class base {

	public  static WebDriver driver;
	public 	static Properties prop;
	public  static WebDriverWait wait;
	public static boolean captureScreenshotflag;

	public WebDriver intializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
//		String browserName = System.getProperty("browser");

		if (browserName.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Driver_Executables\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
			options.addArguments("--headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

		}

		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"E:\\Selenium Practice 27Mar2021\\Selenium-Practice-27Mar2021\\Practice_Selenium\\Driver_Executables\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"E:\\Selenium Practice 27Mar2021\\Selenium-Practice-27Mar2021\\Practice_Selenium\\Driver_Executables\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);

		return driver;

	}
	
	
	
	@BeforeClass
	public void openBrowser_Enter_the_Url() throws IOException
	{
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	
	@AfterClass
	public void close_the_browser()
	{
		
		driver.close();
	}

	public String getScreenShotPath(String methodName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//reports//" + methodName+" "+getDatePath()+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

	public String getDatePath() {

		Date Date_with_Colan = new Date();
		String D1 = Date_with_Colan.toString();
		String Date_with_hyphen = D1.replace(":","-").replace(" ", "-");
		
		return Date_with_hyphen;

	}
	
	
	public  boolean captureScreenshotSelectedPassedTest()
	{
		return captureScreenshotflag;
		
	}

}
