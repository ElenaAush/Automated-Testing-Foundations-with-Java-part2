package framework.page.yopmail;

import framework.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.exception.NotFindElementInPageException;

import java.time.Duration;

public class YopmailEmailPage extends AbstractPage {
    
    private static final Logger log = LogManager.getRootLogger();
    
    private static final String emailsFrameLocator = "ifinbox";
    private static final String contentOfEmailFrameLocator = "ifmail";
    private static final By emailInBoxLocator = By.xpath("//div[@currentmail]");
    
    @FindBy(xpath = "//div[@class='bname']")
    private WebElement emailAddressLabel;
    
    @FindBy(id = "refresh")
    private WebElement refreshButton;
    
    @FindBy(xpath = "//table//tr/td[@colspan='3']/following::td[1]")
    private WebElement totalCost;
    
    public YopmailEmailPage openLastEmail() {
        waitingForEmailContent();
        return this;
    }
    
    public String getEmailAddress() {
        return emailAddressLabel.getText();
    }
    
    public String getTotalCost() {
        goToFrameInEmailContent();
        return totalCost.getText();
    }
    
    private void waitingForEmailContent() {
        int numberOfUpdates = 0;
        boolean isEmailInBox;
        
        while (numberOfUpdates != NUMBER_OF_UPDATES) {
            isEmailInBox = isEmailFormGoogleInBox();
            if (isEmailInBox) {
                log.info("email arrived after {} updates", numberOfUpdates);
                return;
            }
            numberOfUpdates++;
        }
        log.error("email not received after {} updates", numberOfUpdates);
        throw new NotFindElementInPageException("Email not received");
    }
    
    private boolean isEmailFormGoogleInBox() {
        try {
            driver.switchTo().frame(emailsFrameLocator);
            new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated(emailInBoxLocator));
            driver.switchTo().defaultContent();
            return true;
        } catch (TimeoutException e) {
            driver.switchTo().defaultContent();
            refreshButton.click();
            return false;
        }
    }
    
    private void goToFrameInEmailContent() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_SECONDS))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(contentOfEmailFrameLocator));
    }
}
