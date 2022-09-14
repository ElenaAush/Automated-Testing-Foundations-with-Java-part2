package framework.test;

import framework.driver.DriverSingleton;
import framework.service.Tabs;
import framework.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import framework.page.AbstractPage;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class CommonConditions {
    protected WebDriver driver;
    
    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
        AbstractPage.setDriver(driver);
        Tabs.setDriver(driver);
    }
    
    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        Tabs.closeAllExceptOne();
        Tabs.dropDriver();
        DriverSingleton.closeDriver();
    }
}
