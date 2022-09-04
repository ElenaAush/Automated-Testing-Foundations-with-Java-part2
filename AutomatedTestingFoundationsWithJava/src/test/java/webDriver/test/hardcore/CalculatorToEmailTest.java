package webDriver.test.hardcore;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webDriver.exception.NotFindElementInPageException;
import webDriver.service.GoogleCloudService;
import webDriver.service.Tabs;
import webDriver.page.cloudGoogle.GoogleCloudEstimatePage;
import webDriver.page.yopmail.YopmailGeneratedEmailPage;
import webDriver.page.yopmail.YopmailHomePage;
import webDriver.test.BaseTest;

public class CalculatorToEmailTest extends BaseTest {
    GoogleCloudEstimatePage windowGoogleCloud;
    YopmailGeneratedEmailPage windowEmail;
    
    @BeforeClass
    public void setPropertiesForTabs() {
        Tabs.setDriver(driver);
        try {
            windowGoogleCloud = GoogleCloudService.getEstimatePage();
        } catch (NotFindElementInPageException e) {
            e.printStackTrace();
        }
    }
    
    @Test(description = "open and enter calculator, open email in new window, sent results of calculator to email, " +
            "check total cost in calculator and email")
    public void checkTotalCostInCalculatorEqualsTotalCostInEmail() {
        String costFromGoogle;
        String costFromEmail;
        String email;
        
        costFromGoogle = windowGoogleCloud.getTotalCost();
        Tabs.openNewTab();
        windowEmail = new YopmailHomePage().generateEmail();
        email = windowEmail.getGeneratingEmail();
        Tabs.goTab(0);
        windowGoogleCloud.sendByEmail(email);
        Tabs.goTab(1);
        costFromEmail = windowEmail.checkEmail().getTotalCost();
        
        Assert.assertTrue(costFromGoogle.contains(costFromEmail));
    }
    
    @AfterClass(description = "close all tabs except one and drop properties for tabs")
    public void closeAllTabs() {
        Tabs.closeAllTabsExceptOne();
        Tabs.dropDriver();
    }
}
