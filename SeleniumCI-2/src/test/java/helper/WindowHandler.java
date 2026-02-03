package helper;

import org.openqa.selenium.WebDriver;
import java.util.Set;

public class WindowHandler {
    private WebDriver driver;
    private String mainWindowHandle;

    public WindowHandler(WebDriver driver) {
        this.driver = driver;
        this.mainWindowHandle = driver.getWindowHandle();
    }

    /**
     * Switches to a new window/tab (the last one opened)
     */
    public void switchToNewWindow() {
        Set<String> handles = driver.getWindowHandles();
        if(handles.size() > 1) {
        	for (String handle : handles) {
                if (!handle.equals(mainWindowHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
        }
        
    }

    /**
     * Switches to a window by its title
     * @param windowTitle The title of the window to switch to
     * @return true if window was found and switched to, false otherwise
     */
    public boolean switchToWindowByTitle(String windowTitle) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(windowTitle)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Switches to a window by its URL
     * @param url The URL (or part of URL) of the window to switch to
     * @return true if window was found and switched to, false otherwise
     */
    public boolean switchToWindowByUrl(String url) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().contains(url)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Switches back to the main window
     */
    public void switchToMainWindow() {
        driver.switchTo().window(mainWindowHandle);
    }

    /**
     * Closes the current window and switches back to main window
     */
    public void closeCurrentAndSwitchToMain() {
        driver.close();
        switchToMainWindow();
    }

    /**
     * Gets the count of open windows/tabs
     * @return number of open windows
     */
    public int getWindowCount() {
        return driver.getWindowHandles().size();
    }
}