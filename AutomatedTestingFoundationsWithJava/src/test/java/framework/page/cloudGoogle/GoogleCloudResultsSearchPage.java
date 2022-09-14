package framework.page.cloudGoogle;

import framework.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.exception.NotFindElementInPageException;

import java.time.Duration;
import java.util.List;

public class GoogleCloudResultsSearchPage extends AbstractPage {
    private static final Logger log = LogManager.getRootLogger();
    
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
        if (step == NUMBER_OF_UPDATES) {
            log.error("the request didn't appear after {} updates", step);
            throw new NotFindElementInPageException("the request didn't appear");
        }
        
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_SECONDS)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(resultsOfSearchLocator));
        List<WebElement> resultsOfSearch = driver.findElements(resultsOfSearchLocator);
        
        for (WebElement link : resultsOfSearch) {
            if (link.getText().equals(requestName)) {
                link.click();
                log.info("found request after {} updates", step);
                return;
            }
        }
        driver.navigate().refresh();
        searchForLink(step + 1);
    }
}
