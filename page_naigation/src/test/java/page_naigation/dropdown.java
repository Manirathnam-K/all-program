package page_naigation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class dropdown {

	public static void main(String[] args) {
		ChromeOptions options =new ChromeOptions();
		WebDriver driver =new ChromeDriver(options);
		options.addArguments("--starts-maximum");
		
		driver.get("https://www.amazon.in/");
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

        // Open dropdown using RETURN key
        dropdown.sendKeys(Keys.RETURN);

        // Now collect all options
        List<WebElement> allOptions = driver.findElements(
                By.xpath("//select[@id='searchDropdownBox']/option")
        );
        
        // Print all options
        System.out.println("Total options: " + allOptions.size());
        System.out.println("------- Dropdown List -------");


        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }

		
		driver.quit();
		
	}

}
