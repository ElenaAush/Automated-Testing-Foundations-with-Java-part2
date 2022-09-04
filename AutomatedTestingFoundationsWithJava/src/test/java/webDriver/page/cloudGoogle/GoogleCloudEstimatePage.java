package webDriver.page.cloudGoogle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.page.AbstractPage;

import java.time.Duration;

public class GoogleCloudEstimatePage extends AbstractPage {
    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[1]/div")
    private WebElement region;
    
    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[3]/div")
    private WebElement commitmentTerm;
    
    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[4]/div")
    private WebElement provisioningModel;
    
    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[5]/div[1]")
    private WebElement instanceType;
    
    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[7]/div[1]")
    private WebElement localSSD;
    
    @FindBy(xpath = "//h2/b")
    private WebElement totalCost;
    
    @FindBy(id = "email_quote")
    private WebElement emailButton;
    
    public String getRegion() {
        return region.getText();
    }
    
    public String getCommitmentTerm() {
        return commitmentTerm.getText();
    }
    
    public String getProvisioningModel() {
        return provisioningModel.getText();
    }
    
    public String getInstanceType() {
        return instanceType.getText();
    }
    
    public String getLocalSSD() {
        return localSSD.getText();
    }
    
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
