package framework.page.cloudGoogle;

import framework.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudEstimatePage extends AbstractPage {
    
    @FindBy(xpath = "//h2/b")
    private WebElement totalCost;
    
    @FindBy(id = "email_quote")
    private WebElement emailButton;
    
    public String getTotalCost() {
        return totalCost.getText();
    }
    
    public GoogleCloudEstimatePage sendByEmail(String email) {
        switchFrames();
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_SECONDS)).until(ExpectedConditions.elementToBeClickable(emailButton));
        emailButton.click();
        new GoogleCloudEmailPage().sendEmail(email);
        return this;
    }
    
    private void switchFrames() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
    }
}
