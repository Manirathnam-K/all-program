package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
	
	private static FileInputStream fileinputstream;
	private static Properties property;
	private static boolean isLoaded = false;
	
	public static void setupProperty() throws IOException {
	    if (!isLoaded) {
	        File file = new File("/Users/Admin/eclipse-workspace/Maven_Project/src/main/resources/TestData.properties");
	        try {
	            fileinputstream = new FileInputStream(file);
	            property = new Properties();
	            property.load(fileinputstream);
	            isLoaded = true;
	        } catch(FileNotFoundException e){
	            Assert.fail("Error: Occurs while loading");
	        } catch(Exception e) {
	            Assert.fail("Error: Occurs while Reading");
	        }
	    }
	}
	public static String getDataProperty(String datavalue) throws IOException {
		setupProperty();
		String Property = property.getProperty(datavalue);
		//System.out.println("getDataProperty(" + datavalue + ") = " + Property); // Debug log
		return Property;
	}
	public static void main(String args[]) throws IOException {
	System.out.println(getDataProperty("browser"));
	}
	}