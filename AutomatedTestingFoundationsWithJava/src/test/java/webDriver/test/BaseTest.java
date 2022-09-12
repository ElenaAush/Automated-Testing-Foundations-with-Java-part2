package webDriver.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import webDriver.page.AbstractPage;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        AbstractPage.setDriver(driver);
    }
    
    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }
}
