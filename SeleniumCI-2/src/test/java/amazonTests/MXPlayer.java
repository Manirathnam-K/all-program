package amazonTests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import helper.BaseTestAmazonSite;
import helper.TestListener;

@Listeners(TestListener.class)
public class MXPlayer extends BaseTestAmazonSite{
  @Test
  public void clickAmazonBasics() {
	  driver.findElement(By.linkText("MX Player")).click();
	  String newurl = driver.getCurrentUrl();
	  assertTrue(newurl.contains("minitv"));
  }
}
