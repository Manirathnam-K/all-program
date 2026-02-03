package com.base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class Base_class {
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static File file;
	

	// Launch Browser
	protected static void LaunchBrowser(String browsername) {
		try {
			if (browsername.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (browsername.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browsername.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else if (browsername.equalsIgnoreCase("Safari")) {
				driver = new SafariDriver();
			}
		} catch (Exception e) {
			Assert.fail("Error occurred while launching browser");
		}
		driver.manage().window().maximize();

	}

	// closebrowser
	protected static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("Error : occurred while close browser");
		}
	}

	// quitbrowser
	protected static void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("Error : occurred while quit browser");
		}
	}

	// navigation
	protected static void pagenavigation(String actionOrUrl) {
		try {
			if (actionOrUrl.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (actionOrUrl.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (actionOrUrl.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			Assert.fail("Error: occurred while page navigation ");
		}
	}

	// Launch URL
	protected static  void LaunchUrl(String URL) {
		try {
			driver.get(URL); 
		} catch (Exception e) {
			Assert.fail("Error : occurred while navigating to URL");
		}
		;
	}

	// elementclick
	protected static void elementClick(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			Assert.fail("Error : occurred while element click:" + e.getMessage());
		}
	}

	// inputvalueelement
	protected static void inputValueElement(WebElement element, String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("Error : occurred while entering value in element");
		}
	}

	// click
	protected static void click(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			element.click();
		} catch (Exception e) {
			Assert.fail("Error : occurred while click");
		}
	}

	// gettitle
	protected static void getTitle() {
		try {
			driver.getTitle();
		} catch (Exception e) {
			Assert.fail("Error : occurred while getting title");
		}
	}

	// Get attribute()
	protected static void getAttribute(WebElement element, String attribute) {
		try {
			element.getAttribute(attribute);
		} catch (Exception e) {
			Assert.fail("Error : occurred while getting attribute");
		}
	}

	// getcurrenturl
	protected static void getCurrentUrl() {
		try {
			driver.getCurrentUrl();
		} catch (Exception e) {
			Assert.fail("Error : occurred while getting current URL");
		}
	}

	// get attribute
	protected static void getAttribute(WebElement element) {
		try {
			element.getAttribute("value");
		} catch (Exception e) {
			Assert.fail("Error : occurred while getting attribute");
		}
	}

	// windowhandle
	protected static void windowHandling(int num) {
		try {
			List<String> windows = new ArrayList<>(driver.getWindowHandles());
			if (num < windows.size()) {
				driver.switchTo().window(windows.get(num));
			}
		} catch (Exception e) {
			Assert.fail("Error occurred while switching window: " + e.getMessage());
		}
	}

	// select
	protected static void selectOption(WebElement element, String option, String value) {
		try {
			Select select = new Select(element);
			if (option.equalsIgnoreCase("byvalue")) {
				select.selectByValue(value);
			} else if (option.equalsIgnoreCase("byvisibletext")) {
				select.selectByVisibleText(value);
			} else if (option.equalsIgnoreCase("byindex")) {
				int index = Integer.parseInt(value);
				select.selectByIndex(index);
			}
		} catch (Exception e) {
			Assert.fail("Error : occurred while selecting option");
		}
	}

	// DeSelect
	protected static void deSelectOption(WebElement element, String option, String value) {
		try {
			Select select = new Select(element);
			if (option.equalsIgnoreCase("byvalue")) {
				select.deselectByValue(value);
			} else if (option.equalsIgnoreCase("byvisibletext")) {
				select.deselectByVisibleText(value);
			} else if (option.equalsIgnoreCase("byindex")) {
				int index = Integer.parseInt(value);
				select.deselectByIndex(index);
			}
		} catch (Exception e) {
			Assert.fail("Error : occurred while deselecting option");
		}
	}

	// isDisplayed
	protected static void isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
		} catch (Exception e) {
			Assert.fail("Error : occurred while checking isDisplayed");
		}
	}

	// isEnabled
	protected static void isEnabled(WebElement element) {
		try {
			element.isEnabled();
		} catch (Exception e) {
			Assert.fail("Error : occurred while checking isEnabled");
		}
	}

	// isSelected
	protected static void isSelected(WebElement element) {
		try {
			element.isSelected();
		} catch (Exception e) {
			Assert.fail("Error : occurred while checking isSelected");
		}
	}

	// Is multiple
	protected static void isMultiple(WebElement element) {
		try {
			Select select = new Select(element);
			select.isMultiple();
		} catch (Exception e) {
			Assert.fail("Error : occurred while checking isMultiple");
		}
	}

	// implicitwait
	protected static void implicitWait(int time) {
		try {
			driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(time));
		} catch (Exception e) {
			Assert.fail("Error : occurred while applying implicit wait");
		}
	}

	// Explicitwait
	protected static void explicitWait(WebElement element, String condition, int time) {
		WebElement result = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

			if (condition.equalsIgnoreCase("visible")) {
				result = wait.until(ExpectedConditions.visibilityOf(element));
			} else if (condition.equalsIgnoreCase("clickable")) {
				result = wait.until(ExpectedConditions.elementToBeClickable(element));
			} else if (condition.equalsIgnoreCase("present")) {
				Assert.fail("Use locator for 'present' condition, not WebElement");
			}
		} catch (Exception e) {
			Assert.fail("Error: occurred while applying explicit wait");
		}
	}

	// Alert
	protected static void alertHandle(String action) {
		try {
			Alert alert = driver.switchTo().alert();
			if (action.equalsIgnoreCase("accept")) {
				alert.accept();
			} else if (action.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			} else if (action.equalsIgnoreCase("gettext")) {
				String text = alert.getText();
				System.out.println("Alert Text: " + text);	}
		} catch (Exception e) {
			Assert.fail("Error : occurred while handling alert");
		}
	}

	// clear
	protected static void clearElement(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			Assert.fail("Error : occurred while clearing element");
		}
	}

	// gettext
	protected static void getText(WebElement element) {
		try {
			element.getText();
		} catch (Exception e) {
			Assert.fail("Error : occurred while getting text from element");
		}
	}

	// javascriptscroll
	protected static void javascriptScroll(WebElement element, String type) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			if (type.equalsIgnoreCase("intoView")) {
				js.executeScript("arguments[0].scrollIntoView(true);", element);
			} else if (type.equalsIgnoreCase("top")) {
				js.executeScript("window.scrollTo(0, 0);");
			} else if (type.equalsIgnoreCase("bottom")) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			}
		} catch (Exception e) {
			Assert.fail("Error: Occurred while scrolling using JavaScript");

		}

	}

	// Actionclass
	protected static void action(WebElement element, String actionType) {
		Actions actions = new Actions(driver);
		try {
			if (actionType.equalsIgnoreCase("click")) {
				actions.click(element).perform();
			} else if (actionType.equalsIgnoreCase("doubleclick")) {
				actions.doubleClick(element).perform();
			} else if (actionType.equalsIgnoreCase("rightclick")) {
				actions.contextClick(element).perform();
			} else if (actionType.equalsIgnoreCase("hover")) {
				actions.moveToElement(element).perform();
			}
		} catch (Exception e) {
			Assert.fail("Error: occurred while performing action");
		}
	}

	// Screenshort
	protected static void screenshots() {
		try {
			Date currentDate = new Date();
			String dateFile = currentDate.toString().replace(" ", "_").replace(":", "_");
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("//Maven_Project/Screenshot"+"Screenshot_" + dateFile + ".png"));

		} catch (Exception e) {
			Assert.fail("Error: occurred while screenshot");
		}
	}

//ExtentReportStart
protected static void extentReportStart(String location) {
	extentReports =new ExtentReports();
	file =new File(location);
	ExtentSparkReporter SparkReporter = new ExtentSparkReporter(file);
	extentReports.attachReporter(SparkReporter);
	extentReports.setSystemInfo("OS",System.getProperty("OS.name"));
}

protected static void extentReportTeardown(String location) throws IOException{
	 extentReports.flush();
	file =new File(location);
	Desktop.getDesktop().browse((file).toURI());
}

}



//==========================================================================================//
//
//		protected static WebDriver elementClick(WebElement element) {		
//			try {
//				element.click();
//			} catch (Exception e) {
//				Assert.fail("Error occurred while element click");
//			}
//			}

//	Base Class Methods:
//		===================
//			1.	Browser launch() - Done
//			2.	Close() - Done
//			3.	Quit() - Done
//			4.	Navigate to() - Done
//			5.	Navigate back() - Done
//			6.	Navigate forward () - Done
//			7.	Navigate refresh() - Done
//			8.	Get() - Done
//			9.	Alert() - Done
//			10.	Action(All methods from action class)
//			11.	Frames()
//			12.	Robot()
//			13.	Window handles()
//			14.	Drop down () - Done
//			15.	Check box() - 
//			16.	Is enable() - Done
//			17.	Is displayed() - Done
//			18.	Is selected() - Done
//			19.	Get options()
//			20.	Get title() - Done
//			21.	Get current url() - Done
//			22.	Get text() - Done
//			23.	Get attribute()-Done
//			24.	Wait()
//			25.	Take screenshot()
//			26.	Scroll up and down()
//			27.	Sendkeys() - Done
//			28.	Get first selected options()
//		    29.	Get all selected options()
//		    30.	Is multiple() - Done
//		    31.	Click() - Done
//		    32. RadioButton()
//		    33. Java Script Executor - All Methods
