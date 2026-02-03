package TestCases;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import java.io.File;
import org.testng.Assert;

public class DownloadTest2Firefox {
    public static void main(String[] args) throws InterruptedException {
        // Create Firefox profile
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", System.getProperty("user.dir"));
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        
        WebDriver driver = new FirefoxDriver(options);

        // Perform download
        driver.get("https://example.com/download.pdf");
        
        // Wait and verify
        Thread.sleep(5000);
        File downloadedFile = new File("downloaded_file.pdf");
        Assert.assertTrue(downloadedFile.exists(), "File not downloaded");

        driver.quit();
    }
}