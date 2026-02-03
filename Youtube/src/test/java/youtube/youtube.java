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

public class youtube { // Renamed class to follow Java conventions

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable if not set in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            driver.get("https://www.youtube.com");
            driver.manage().window().maximize();
            //1
            WebElement searchBox = driver.findElement(By.name("search_query"));
            searchBox.sendKeys("programming videos");
            searchBox.sendKeys(Keys.RETURN);
            //2
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("video-title")));
            List<WebElement> videoLinks = driver.findElements(By.id("video-title"));
            if (videoLinks.isEmpty()) {
                System.out.println("No videos found.");
                return;
            }
            Random rand = new Random();
            int randomVideoIndex = rand.nextInt(videoLinks.size());
            WebElement randomVideo = videoLinks.get(randomVideoIndex);
            System.out.println("Playing video: " + randomVideo.getAttribute("title"));
            randomVideo.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("video")));
            System.out.println("Video player is loaded.");

            Actions actions = new Actions(driver);
            // Use WebDriverWait for scrolling and loading comments
            for (int i = 0; i < 10; i++) {
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                // Wait for a short duration using WebDriverWait instead of Thread.sleep
                wait.withTimeout(Duration.ofSeconds(2));
            }

            By commentsSectionLocator = By.xpath("//ytd-comments[@id='comments']");
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(commentsSectionLocator));
                System.out.println("Comments section is visible.");
            } catch (Exception e) {
                System.out.println("Failed to load the comments section.");
                return;
            }

            // Wait for comments to load fully
            wait.withTimeout(Duration.ofSeconds(5));

            List<WebElement> comments = driver.findElements(By.xpath("//*[@id='content-text']"));
            System.out.println("Found " + comments.size() + " comments.");
            int commentCount = Math.min(comments.size(), 40);
            for (int i = 0; i < commentCount; i++) {
                System.out.println("Comment " + (i + 1) + ": " + comments.get(i).getText());
            }
        } finally {
            // Ensure the browser is closed even if an exception occurs
            driver.quit();
        }
    }
}