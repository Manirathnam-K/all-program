package TestCases;

import org.openqa.selenium.WebDriver;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.Test;


public class FileUploadTest2 {

  @Test
  public void fileUploadTest() {
	WebDriver driver = new ChromeDriver();
    driver.get("https://practice.expandtesting.com/upload");
    File uploadFile = new File("src/test/resources/browserstack.png");

    WebElement fileInput = driver.findElement(By.cssSelector("#fileInput"));
    fileInput.sendKeys(uploadFile.getAbsolutePath());
    driver.findElement(By.id("fileSubmit")).click();

    WebElement uploadedEle = driver.findElement(By.tagName("h1"));
    String uploadedText = uploadedEle.getText();
    assertEquals("File Uploaded!", uploadedText);
    
    WebElement fileEle = driver.findElement(By.id("uploaded-files"));
    String fileName = fileEle.getText();
    assertTrue(fileName.contains("browserstack"));
    
  }
}
