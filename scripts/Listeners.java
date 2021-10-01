package scripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterTesNG;
import resources.base;

public class Listeners extends base implements ITestListener {
	
	ExtentReports extent = ExtentReporterTesNG.getReportsObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTestInstance = new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTestInstance.set(test);

	}

	public void onFinish(ITestContext arg0) {
		extent.flush();

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {

		extentTestInstance.get().log(Status.FAIL, "Test is Failed");
		WebDriver driver = null;
		extentTestInstance.get().fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			getScreenShotPath(result.getMethod().getMethodName(), driver);
			String methodname = result.getMethod().getMethodName();
			extentTestInstance.get().addScreenCaptureFromPath(getScreenShotPath(methodname, driver),
					System.getProperty("user.dir") + "//reports//" + methodname + " " + getDatePath() + ".png");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		extentTestInstance.get().log(Status.SKIP, "Test is skipped");

	}

	public void onTestSuccess(ITestResult result) {
		extentTestInstance.get().log(Status.PASS, "Test is Passed");
		
		
		if (captureScreenshotSelectedPassedTest()) {
			WebDriver driver = null;
			extentTestInstance.get().pass(result.getThrowable());
			
			try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				getScreenShotPath(result.getMethod().getMethodName(), driver);
				String methodname = result.getMethod().getMethodName();
				extentTestInstance.get().addScreenCaptureFromPath(getScreenShotPath(methodname, driver),
						System.getProperty("user.dir") + "//reports//" + methodname + " " + getDatePath() + ".png");
				captureScreenshotflag=false;
				

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
