package webDriver.page.cloudGoogle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webDriver.page.AbstractPage;

public class GoogleCloudEmailPage extends AbstractPage {
    @FindBy(xpath = "//*[@ng-model='emailQuote.user.email']")
    private WebElement emailField;
    
    @FindBy(xpath = "//form/md-dialog-actions/button[2]")
    private WebElement sendEmailButton;
    
    protected void sendEmail(String email) {
        emailField.sendKeys(email);
        sendEmailButton.click();
    }
}
