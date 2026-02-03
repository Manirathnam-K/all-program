package TestCases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;

public class DownloadTest1Chrome {
    public static void main(String[] args) throws InterruptedException {
        // Set download directory path
        String downloadPath = System.getProperty("user.dir") + File.separator + "downloads";
        File downloadDir = new File(downloadPath);
        if (!downloadDir.exists()) {
            downloadDir.mkdir();
        }

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadPath);
        chromePrefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Perform download action
        driver.get("https://example.com/download");
        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        // Wait for download to complete
        Thread.sleep(5000); // Consider using explicit wait in production

        // Verify download
        File[] files = downloadDir.listFiles();
        Assert.assertTrue(files != null && files.length > 0, "No files were downloaded");

        // Check for specific file type
        boolean hasPdf = false;
        for (File file : files) {
            if (file.getName().endsWith(".pdf")) {
                hasPdf = true;
                break;
            }
        }
        Assert.assertTrue(hasPdf, "No PDF file was downloaded");

        driver.quit();
    }
}