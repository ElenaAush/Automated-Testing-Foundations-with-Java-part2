package webDriver.page.yopmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webDriver.page.AbstractPage;

public class YopmailGeneratedEmailPage extends AbstractPage {
    @FindBy(id = "egen")
    private WebElement email;
    
    @FindBy(xpath = "//*[@id='egen']/..//button[@onclick='egengo();']")
    private WebElement checkEmailButton;
    
    public String getGeneratingEmail() {
        return email.getText();
    }
    
    public YopmailEmailPage checkEmail() {
        checkEmailButton.click();
        return new YopmailEmailPage();
    }
}
