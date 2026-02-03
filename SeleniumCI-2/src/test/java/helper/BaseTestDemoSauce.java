package helper;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTestDemoSauce extends BaseTest{
	
    String demoSauceUrl = config.getDemoSauceTestUrl();

    @BeforeClass
    public void setUp() {
    	config = new ConfigReader();
        driver.get(demoSauceUrl);
    }
    
    public WebDriver getDriver() {
        return driver;
    }
}
