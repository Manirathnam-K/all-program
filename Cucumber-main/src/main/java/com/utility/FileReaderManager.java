package com.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
public class FileReaderManager {
    private static FileInputStream fileinputstream;
    private static Properties properties;

    public static void main(String[] args) throws IOException {
        System.out.println(getDataProperty("browser"));
    }

    public static String getDataProperty(String datavalue) throws IOException {
        setupproperty();
        String property = properties.getProperty(datavalue);
        return property;
    }

    private static void setupproperty() throws IOException {
        File file = new File("C:\\Users\\ZORO\\eclipse-workspace\\CUCUMBER_PROJECT\\src\\main\\resources\\NaukriData.properties");
        try {
            fileinputstream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileinputstream);
        } catch (Exception e) {
            Assert.assertNotNull("ERROR: OCCUR DURING LOADING", "ERROR: OCCUR DURING READING");
        }
    }
    public static String getDataProperty1(String datavalue) throws IOException {
        if (properties == null) {
            setupproperty();
        }
        return properties.getProperty(datavalue);
    }

    public static String getUrl() throws IOException {
        return getDataProperty("url");
    }

    public static String getUsername() throws IOException {
        return getDataProperty("username");
    }

    public static String getPassword() throws IOException {
        return getDataProperty("password");
    }

	
	}
