package helper;

import org.testng.annotations.BeforeMethod;

public class BaseTestAmazonSite extends BaseTest{

    String amzUrl = config.getAmzTestUrl();
    
    @BeforeMethod
    public void beforeClass() {
    	System.out.println("iam before class - amazon test");
        driver.get(amzUrl);
    }
    
}
