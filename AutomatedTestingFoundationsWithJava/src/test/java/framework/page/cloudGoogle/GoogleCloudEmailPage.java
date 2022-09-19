package framework.page.cloudGoogle;

import framework.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudEmailPage extends AbstractPage {
    
    private static final Logger log = LogManager.getRootLogger();
    
    @FindBy(xpath = "//*[@ng-model='emailQuote.user.email']")
    private WebElement emailField;
    
    @FindBy(xpath = "//form/md-dialog-actions/button[2]")
    private WebElement sendEmailButton;
    
    protected void sendEmail(String email) {
        emailField.sendKeys(email);
        sendEmailButton.click();
        log.info("email sent");
    }
}
