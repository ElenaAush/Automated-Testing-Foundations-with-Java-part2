package framework.util;

import framework.driver.DriverSingleton;
import framework.service.StringCreator;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
    private static final Logger log = LogManager.getRootLogger();
    
    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot();
    }
    
    private void saveScreenshot() {
        File screenCapture = ((TakesScreenshot)DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(".//target/screenshot/" + StringCreator.getCurrentTimeAsString() + ".png"));
        } catch (IOException e) {
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }
}
