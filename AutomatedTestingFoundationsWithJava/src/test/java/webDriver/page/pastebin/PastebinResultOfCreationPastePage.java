package webDriver.page.pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.page.AbstractPage;

import java.time.Duration;

public class PastebinResultOfCreationPastePage extends AbstractPage {
    private static final By massageOfSuccessLocator = By.xpath("//div[@class='notice -success -post-view']");
    
    @FindBy(xpath = "//div[@class='top-buttons']/div[@class='left']/a")
    private WebElement syntaxHighlightingButton;
    
    @FindBy(xpath = "//textarea")
    private WebElement codePasteTestArea;
    
    public boolean isPastCreated() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_SECONDS)).until(ExpectedConditions.presenceOfElementLocated(massageOfSuccessLocator));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
    
    public String getTitleBrowser() {
        return driver.getTitle();
    }
    
    public String getSyntaxHighlighted() {
        return syntaxHighlightingButton.getText();
    }
    
    public String getCodePaste() {
        return codePasteTestArea.getText();
    }
}
