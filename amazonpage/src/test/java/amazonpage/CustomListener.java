package amazonpage;

import org.testng.ITestListener;

public class CustomListener extends Base implements ITestListener{
	
	@Override
	public void onTestFailure(org.testng.ITestResult result) {
		System.out.println("Test failed: " + result.getName());
		failed();
	}

	@Override
	public void onTestStart(org.testng.ITestResult result) {
		initialization();
	}
	
	// You can override other methods if needed, such as onTestSuccess, onTestSkipped, etc.	
	@Override
	public void onTestSuccess(org.testng.ITestResult result) {
		System.out.println("Test passed: " + result.getName());
	}
	@Override	
	public void onTestSkipped(org.testng.ITestResult result) {
		System.out.println("Test skipped: " + result.getName());
	}
	@Override	
	public void onTestFailedButWithinSuccessPercentage(org.testng.ITestResult result) {
		System.out.println("Test failed but within success percentage: " + result.getName());
	}
	@Override
	public void onStart(org.testng.ITestContext context) {
		System.out.println("Test started: " + context.getName());
	}
	@Override
	public void onFinish(org.testng.ITestContext context) {
		System.out.println("Test finished: " + context.getName());
	}
}
