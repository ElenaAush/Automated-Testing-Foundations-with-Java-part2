package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected static WebDriver driver;
    protected static final int DEFAULT_WAITING_TIME_SECONDS = 10;
    protected static final int NUMBER_OF_UPDATES = 5;
    protected static final String HOMEPAGE_URL_GOOGLE_CLOUD = "https://cloud.google.com/";
    protected static final String HOMEPAGE_URL_YOPMAIL = "https://yopmail.com/";
    
    protected AbstractPage() {
        PageFactory.initElements(driver, this);
    }
    
    public static void setDriver(WebDriver driver) {
        AbstractPage.driver = driver;
    }
}
