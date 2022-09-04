package webDriver.page.yopmail;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.exception.NotFindElementInPageException;
import webDriver.page.AbstractPage;

import java.time.Duration;

public class YopmailEmailPage extends AbstractPage {
    private static final String emailsFrameLocator = "ifinbox";
    private static final String contentOfEmailFrameLocator = "ifmail";
    private static final By emailInBoxLocator = By.xpath("//div[@currentmail]");
    
    @FindBy(id = "refresh")
    private WebElement refreshButton;
    
    @FindBy(xpath = "//table//tr/td[@colspan='3']/following::td[1]")
    private WebElement totalCost;
    
    public String getTotalCost() {
        waitingForEmailContent();
        return totalCost.getText();
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
    
    private void waitingForEmailContent() {
        int numberOfUpdates = 0;
        boolean isEmailInBox;
        
        while (numberOfUpdates != 5) {
            isEmailInBox = isEmailFormGoogleInBox();
            if (isEmailInBox) {
                goToFrameInEmailContent();
                return;
            }
            numberOfUpdates++;
        }
        throw new NotFindElementInPageException("Email not sent");
    }
    
    private void goToFrameInEmailContent() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_SECONDS))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(contentOfEmailFrameLocator));
    }
}
