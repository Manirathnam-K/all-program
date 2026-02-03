package helper;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {
    protected static WebDriver driver;
    
    ConfigReader config = new ConfigReader();
    String browser = config.getBrowser();
    String url = config.getApplicationUrl();
    String gridUrl = config.getGridUrl();
    String platform = config.getPlatform();
    String amzUrl = config.getAmzTestUrl();
    String demoSauceUrl = config.getDemoSauceTestUrl();
    
    @BeforeTest
    public void beforeClasss() {
    	config = new ConfigReader();
    	System.out.println(platform+" , "+browser);

    	if(platform.contentEquals("local") && browser.contentEquals("chrome")){
    		ChromeOptions options = new ChromeOptions();
    	    //options.setEnableDownloads(true);
        	//options.addArguments("--headless");
        	//options.addArguments("--disable-gpu");
    		options.setImplicitWaitTimeout(Duration.ofSeconds(10));
    			/*
    			What it does:
					Implicit Wait: This tells Selenium to poll the DOM for a certain amount of time when trying to find elements that aren't immediately available.
					Duration.ofSeconds(7): Sets this wait timeout to 7 seconds.
				Key points to understand:
					This wait is applied globally for the entire WebDriver instance
					It only affects findElement() and findElements() calls
					If the element is found before the timeout, execution continues immediately
					If the element isn't found after 7 seconds, a NoSuchElementException will be thrown
    			 * */
    		driver = new ChromeDriver(options);
    	}
    	else if(platform.contentEquals("local") && browser.contentEquals("firefox")) {
    	    FirefoxProfile profile = new FirefoxProfile();
    	    FirefoxOptions options = new FirefoxOptions();
    	    profile.setPreference("javascript.enabled", "False");
    	    options.setProfile(profile);
    	    driver = new FirefoxDriver(options);
    	}else if(platform.contentEquals("local") && browser.contentEquals("edge")) {
    	    EdgeOptions options = new EdgeOptions();
        	driver = new EdgeDriver(options);
    	}else if(platform.contentEquals("remote")) {
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--headless"); // Headless mode
    		options.addArguments("--no-sandbox"); // Bypass OS security
    		options.addArguments("--disable-dev-shm-usage"); // Prevent /dev/shm issues
    		options.addArguments("--disable-gpu"); // Disable GPU (optional)
    		options.addArguments("--window-size=1920,1080"); // Set window size
    		driver = new ChromeDriver(options);
    	}
    			// Initialize WebDriver
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver.manage().window().maximize();

    }
    
    @AfterTest
    public void afterClasss() {
        if (driver != null) {
            driver.quit();
        }
    }

}