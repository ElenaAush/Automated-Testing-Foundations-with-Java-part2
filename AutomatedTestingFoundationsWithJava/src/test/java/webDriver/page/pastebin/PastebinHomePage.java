package webDriver.page.pastebin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webDriver.page.AbstractPage;

public class PastebinHomePage extends AbstractPage {
    @FindBy(id = "postform-text")
    private WebElement codeTextArea;
    
    @FindBy(xpath = "//*[@id='select2-postform-format-container']/following::span")
    private WebElement syntaxHighlightingDropList;
    
    @FindBy(xpath = "//*[@id='select2-postform-format-results']//*[text()='Bash']")
    private WebElement valueBashFromSyntaxHighlighting;
    
    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']/..")
    private WebElement pasteExpirationDropList;
    
    @FindBy(xpath = "//*[@id='select2-postform-expiration-results']/*[text()='10 Minutes']")
    private WebElement value10MinutesFromPasteExpiration;
    
    @FindBy(id = "postform-name")
    private WebElement pasteNameField;
    
    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement newPasteButton;
    
    public PastebinHomePage() {
        driver.get(HOMEPAGE_URL_PASTEBIN);
    }
    
    public PastebinHomePage enterCode(String code) {
        codeTextArea.sendKeys(code);
        return this;
    }
    
    public PastebinHomePage chooseBashInSyntaxHighlighting() {
        syntaxHighlightingDropList.click();
        valueBashFromSyntaxHighlighting.click();
        return this;
    }
    
    public PastebinHomePage choose10MinutesInPasteExpiration() {
        pasteExpirationDropList.click();
        value10MinutesFromPasteExpiration.click();
        return this;
    }
    
    public PastebinHomePage enterPasteName(String name) {
        pasteNameField.sendKeys(name);
        return this;
    }
    
    public PastebinResultOfCreationPastePage addNewPaste() {
        newPasteButton.click();
        return new PastebinResultOfCreationPastePage();
    }
    
    public String getCode() {
        return codeTextArea.getAttribute("value");
    }
    
    public String getExpirationInDropList() {
        return pasteExpirationDropList.getText();
    }
    
    public String getNamePaste() {
        return pasteNameField.getAttribute("value");
    }
}
