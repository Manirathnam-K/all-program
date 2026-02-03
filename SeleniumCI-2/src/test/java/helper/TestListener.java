package helper;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	
    @Override
    public void onTestFailure(ITestResult result) {
        // Get driver from test class
        Object testClass = result.getInstance();
        WebDriver driver = BaseTest.driver;
       // WebDriver driver = ((BaseTest) testClass).getDriver(); // Replace with your base test class
        
        // Capture screenshot
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
        
        // Log or attach screenshot to report
        System.out.println("Screenshot captured for failed test: " + result.getName());
        System.out.println("Screenshot path: " + screenshotPath);
        
        // You can also attach screenshot to TestNG report
        result.setAttribute("screenshot", screenshotPath);
        
        
    }
    
    // Other methods can remain empty if not needed
    @Override public void onTestStart(ITestResult result) {}
    
    
    @Override public void onTestSuccess(ITestResult result) {
    	
    	// Get driver from test class
        Object testClass = result.getInstance();
        WebDriver driver = BaseTest.driver;
        //WebDriver driver = ((BaseTest) testClass).getDriver(); // Replace with your base test class
        
        // Capture screenshot
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
        
        // Log or attach screenshot to report
        System.out.println("Screenshot captured for failed test: " + result.getName());
        System.out.println("Screenshot path: " + screenshotPath);
        
        // You can also attach screenshot to TestNG report
        result.setAttribute("screenshot", screenshotPath);
        
    }
    
    
    @Override public void onTestSkipped(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
}