package amazonTests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import helper.BaseTestAmazonSite;
import helper.MoveToElement;
import helper.WindowHandler;


public class AmazonDeals extends BaseTestAmazonSite {
	
	// navigate to amazon site - goto for amazon live section
	// Click every deals with offers and verify the name of deal matches with page title opens on deal click
	private By deal_tiles = By.cssSelector("div[aria-label='Entering Carousel Tile']:has(div[data-id='DealBadge'])");

//	private By caro_1 = By.cssSelector("div[aria-label='Entering Carousel Tile']+)
//	private By liveSec = By.cssSelector(".amazonlive-widget-padding");
	private By productName = By.cssSelector("[data-id='TileTitle']");
	private By dealPercent = By.cssSelector("[data-id='DealBadge']");


  @Test
  public void checkDeals() throws InterruptedException, IOException {
	  String productNameDisplayed, pageTitleDisplayed;
	  List<WebElement> allDealTiles = driver.findElements(deal_tiles);
	  int dealsCount = allDealTiles.size();
	  System.out.println("Total deals in Amazon Live is : "+dealsCount);
	  
	  System.out.println("firsteleme>>>>>"+(allDealTiles.get(0).getText()));
	  int dealLastIndex = allDealTiles.size()-1;
	  System.out.println("lasteleme>>>>>"+(allDealTiles.get(dealLastIndex).getText()));
	  
	  for(int dealIndex = 0; dealIndex <= dealLastIndex; dealIndex++) {
		  System.out.println();
		  System.out.println("acting on "+dealIndex);
		  WebElement deal = allDealTiles.get(dealIndex);
		  WebElement product = deal.findElement(productName);
		  WebElement percent = deal.findElement(dealPercent);
		  productNameDisplayed = product.getText();
		  
		  String firstWord = productNameDisplayed.split(" ")[0];
		  System.out.println(">>"+firstWord);
		  System.out.println("product is :"+productNameDisplayed);
		  System.out.println("percent is :"+percent.getText());
		  
		  
		  MoveToElement.scrollToElement(driver, product);
		  product.click();
		  
		  WindowHandler windowHandle = new WindowHandler(driver);
		  windowHandle.switchToNewWindow();
		  
		  pageTitleDisplayed = driver.getTitle();
		  System.out.println("title is "+pageTitleDisplayed);
		  
		  windowHandle.closeCurrentAndSwitchToMain();
		  assertTrue(pageTitleDisplayed.contains(firstWord));
		  
		  
		  }
  }
  
  @Test
  public void clickDeals() {
	  
  }

}
