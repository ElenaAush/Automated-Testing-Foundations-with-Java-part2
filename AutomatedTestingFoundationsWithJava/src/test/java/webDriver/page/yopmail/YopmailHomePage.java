package webDriver.page.yopmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webDriver.page.AbstractPage;

public class YopmailHomePage extends AbstractPage {
    @FindBy(xpath = "//*[@id='listeliens']/a[@href='email-generator']")
    private WebElement emailGeneratorButton;
    
    public YopmailHomePage() {
        driver.get(HOMEPAGE_URL_YOPMAIL);
    }
    
    public YopmailGeneratedEmailPage generateEmail() {
        emailGeneratorButton.click();
        return new YopmailGeneratedEmailPage();
    }
}
