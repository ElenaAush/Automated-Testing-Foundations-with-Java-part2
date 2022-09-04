package webDriver.page.cloudGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.exception.NotFindElementInPageException;
import webDriver.page.AbstractPage;

import java.time.Duration;
import java.util.List;

public class GoogleCloudResultsSearchPage extends AbstractPage {
    private final String requestName;
    private static final By resultsOfSearchLocator = By.xpath("//main//div//a[@class='gs-title']");
    
    public GoogleCloudResultsSearchPage(String requestName) {
        this.requestName = requestName;
    }
    
    public GoogleCloudPricingCalculatorPage chooseCalculator() {
        searchForLink(0);
        return new GoogleCloudPricingCalculatorPage();
    }

    private void searchForLink(int step) {
        if (step == 3) {
            throw new NotFindElementInPageException("the required request did not appear");
        }
        
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_SECONDS)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(resultsOfSearchLocator));
        List<WebElement> resultsOfSearch = driver.findElements(resultsOfSearchLocator);
        
        for (WebElement link : resultsOfSearch) {
            if (link.getText().equals(requestName)) {
                link.click();
                return;
            }
        }
        driver.navigate().refresh();
        searchForLink(step + 1);
    }
}
