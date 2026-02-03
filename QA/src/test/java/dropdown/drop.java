package dropdown;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class drop {

    WebDriver driver = null;
    WebDriverWait wait;
    String str;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.co.in/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void searchAmazon() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();
        str = driver.getTitle();
        System.out.println(str);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
    }

    @Test(priority = 2, enabled = true)
    public void dropdown() throws InterruptedException {
        System.out.println(driver.getTitle());
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Actions action = new Actions(driver);
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        System.out.println(dropdown.getText());
    }

    @Test(priority = 3, enabled = true)
    public void watch() throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        search.sendKeys("mobile");
        search.sendKeys(Keys.ENTER);
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Samsung Galaxy')])[1]")));
        product.click();
        wait.until(driverObj -> driverObj.getWindowHandles().size() > 1);
        String parentWindow = driver.getWindowHandle();
        System.out.println("Switched to child window: " + driver.getTitle());
    }

    @Test(enabled = false)
    public void smoke() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links on page: " + links.size());
        for (WebElement link : links) {
            System.out.println("Text: " + link.getText() + " | URL: " + link.getAttribute("href"));
        }
    }

    @Test(enabled = true)
    public void sanity() {
        String url = driver.getCurrentUrl();
        System.out.println(url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}