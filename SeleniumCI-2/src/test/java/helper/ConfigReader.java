package helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private final String propertyFilePath= "configs//config.properties";
    
    public ConfigReader(){
	    BufferedReader reader;
	    
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
    }
//    
//	public String getDriverPath(){
//		String driverPath = properties.getProperty("driverPath");
//		if(driverPath!= null) return driverPath;
//		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
//	}
//	
//	public long getImplicitlyWait() {		
//		String implicitlyWait = properties.getProperty("implicitlyWait");
//		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
//		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
//	}
//	
	public String getApplicationUrl() {
		String url = properties.getProperty("testURL");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getBrowser() {
		String browser = properties.getProperty("browser");
		if(browser != null) return browser;
		else throw new RuntimeException("browser not specified in the Configuration.properties file."); 
	}
	
	public String getPlatform() {
		String browser = properties.getProperty("runPlatform");
		if(browser != null) return browser;
		else throw new RuntimeException("platform not specified in the Configuration.properties file."); 
	}
	
	public String getGridUrl() {
		String gridUrl = properties.getProperty("gridUrl");
		if(gridUrl != null) return gridUrl;
		else throw new RuntimeException("GridUrl not specified in the Configuration.properties file."); 
	}
	
	public String getAmzTestUrl() {
		String amzUrl = properties.getProperty("amzTestUrl");
		if(amzUrl != null) return amzUrl;
		else throw new RuntimeException("URL not specified in the Configuration.properties file."); 
	}
	
	
	public String getDemoSauceTestUrl() {
		String sauceUrl = properties.getProperty("demoSauceUrl");
		if(sauceUrl != null) return sauceUrl;
		else throw new RuntimeException("URL not specified in the Configuration.properties file."); 
	}
	
}