package framework.page.yopmail;

import framework.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailGeneratedEmailPage extends AbstractPage {
    @FindBy(id = "egen")
    private WebElement email;
    
    @FindBy(xpath = "//*[@id='egen']/..//button[@onclick='egengo();']")
    private WebElement emailButton;
    
    public String getGeneratingEmail() {
        return email.getText();
    }
    
    public YopmailEmailPage openEmail() {
        emailButton.click();
        return new YopmailEmailPage();
    }
}
