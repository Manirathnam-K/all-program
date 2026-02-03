package com.Testng;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base_class;

public class ParameterizationClass extends Base_class {
    @Test
    @Parameters ({"username","password"})
    public void parameterizationMethod(String username, String password) {
 
        LaunchBrowser("chrome");
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.quit();
        
    }
}