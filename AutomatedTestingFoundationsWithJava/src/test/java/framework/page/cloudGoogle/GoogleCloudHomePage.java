package framework.page.cloudGoogle;

import framework.page.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {
    @FindBy(xpath = "//div[@class='devsite-searchbox']")
    private WebElement searchButton;
    
    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchField;
    
    public GoogleCloudHomePage() {
        driver.get(HOMEPAGE_URL_GOOGLE_CLOUD);
    }
    
    public GoogleCloudResultsSearchPage searchByRequest(String requestName) {
        searchButton.click();
        searchField.sendKeys(requestName, Keys.ENTER);
        return new GoogleCloudResultsSearchPage(requestName);
    }
}
