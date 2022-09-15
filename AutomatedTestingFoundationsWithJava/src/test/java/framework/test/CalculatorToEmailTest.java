package framework.test;

import framework.page.yopmail.YopmailEmailPage;
import framework.service.YopmailService;
import org.testng.Assert;
import org.testng.annotations.Test;
import framework.page.cloudGoogle.GoogleCloudEstimatePage;
import framework.service.GoogleCloudService;
import framework.service.Tabs;

public class CalculatorToEmailTest extends CommonConditions {
    GoogleCloudEstimatePage windowGoogleCloud;
    YopmailEmailPage windowEmail;
    
    @Test(description = "open and enter calculator, open email in new window, sent results of calculator to email " +
            "and compares total cost in estimate on calculator and in email")
    public void checkTotalCostInCalculatorEqualsTotalCostInEmail() {
        windowGoogleCloud = GoogleCloudService.getEstimatePage();
        String costFromGoogle = windowGoogleCloud.getTotalCost();
        Tabs.openNew();
        windowEmail = YopmailService.openGeneratedEmail();
        String email = windowEmail.getEmailAddress();
        Tabs.goTo(0);
        windowGoogleCloud.sendByEmail(email);
        Tabs.goTo(1);
        String costFromEmail = windowEmail.openLastEmail().getTotalCost();
        Assert.assertTrue(costFromGoogle.contains(costFromEmail));
    }
}
