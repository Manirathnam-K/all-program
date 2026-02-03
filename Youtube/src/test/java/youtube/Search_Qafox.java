package youtube;



import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class Search_Qafox {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeSuite
    public void BrowserLaunch() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();
        // ✅ FIX: initialize wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

}



@BeforeClass

public void SearchUrl() {

        WebElement searchBox = driver.findElement(By.name("search_query"));

        searchBox.sendKeys("programming videos");

        searchBox.sendKeys(Keys.RETURN);

    }



    @Test(priority = 1)

    public void PlayRandomVideo() {



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("video-title")));



        List<WebElement> videoLinks = driver.findElements(By.id("video-title"));

        if (videoLinks.isEmpty()) {

            System.out.println("❌ No videos found.");

            return;

        }



        Random rand = new Random();

        WebElement randomVideo = videoLinks.get(rand.nextInt(videoLinks.size()));



        System.out.println("▶ Playing video: " + randomVideo.getAttribute("title"));

        randomVideo.click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("video")));

        System.out.println("✅ Video player is loaded.");

    }



    @Test(priority = 2, dependsOnMethods = "PlayRandomVideo")

    public void ScrollAndLoadComments() {



        Actions actions = new Actions(driver);

        for (int i = 0; i < 8; i++) {

            actions.sendKeys(Keys.PAGE_DOWN).perform();

        }



        By commentsLocator = By.xpath("//ytd-comments[@id='comments']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(commentsLocator));

        System.out.println("✅ Comments section is visible.");

    }



    @AfterClass

    public void CountComments() {



        List<WebElement> comments = driver.findElements(By.id("content-text"));

        System.out.println("Found " + comments.size() + " comments.");



        int limit = Math.min(comments.size(), 40);

        for (int i = 0; i < limit; i++) {

            System.out.println("Comment " + (i + 1) + ": " + comments.get(i).getText());

        }
    }
    @AfterSuite

    public void Tearfile() {

        driver.quit();

        System.out.println("Browser closed successfully.");

    }

}