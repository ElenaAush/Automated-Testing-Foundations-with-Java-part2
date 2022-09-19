package framework.driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Tabs {
    
    private static WebDriver driver;
    private static List<String> tabs;
    
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
    
    public static void dropDriver() {
        tabs = null;
        driver = null;
    }
    
    public static void openNew() {
        if (tabs == null) {
            initFirst();
        }
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        String newHandle = findNewHandle();
        tabs.add(newHandle);
        driver.switchTo().window(newHandle);
    }
    
    public static void goTo(int index) {
        driver.switchTo().window(tabs.get(index));
    }
    
    public static void closeAllExceptOne() {
        if (tabs == null || tabs.size() <= 1) {
            return;
        }
        
        String currentHandle = driver.getWindowHandle();
        
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
                driver.close();
                tabs.remove(handle);
            }
        }
        driver.switchTo().window(currentHandle);
    }
    
    private static void initFirst() {
        tabs = new ArrayList<>();
        tabs.add(driver.getWindowHandle());
    }
    
    private static String findNewHandle() {
        Set<String> handles = driver.getWindowHandles();
        boolean isNewHandle = true;

        for (String handle : handles) {
            for (String tab : tabs) {
                if (handle.equals(tab)) {
                    isNewHandle = false;
                    break;
                }
            }
            if (isNewHandle) {
                return handle;
            }
            isNewHandle = true;
        }
        return null;
    }
}
