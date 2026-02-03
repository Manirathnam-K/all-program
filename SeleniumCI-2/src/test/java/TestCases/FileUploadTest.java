package TestCases;

import org.openqa.selenium.WebDriver;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FileUploadTest {

  @Test
  public void fileUploadTest() {
	WebDriver driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/upload");
    File uploadFile = new File("src/test/resources/browserstack.png");

    WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
    fileInput.sendKeys(uploadFile.getAbsolutePath());
    driver.findElement(By.id("file-submit")).click();

    WebElement fileName = driver.findElement(By.id("uploaded-files"));
    Assert.assertEquals("browserstack.png", fileName.getText());
  }
}
