package framework.test;

import framework.model.VirtualMachine;
import framework.page.yopmail.YopmailEmailPage;
import framework.model.VirtualMachineCreator;
import framework.service.YopmailService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import framework.page.cloudGoogle.GoogleCloudEstimatePage;
import framework.service.GoogleCloudService;
import framework.driver.Tabs;

public class CalculatorToEmailTest extends CommonConditions {
    
    private GoogleCloudEstimatePage windowGoogleCloud;
    private YopmailEmailPage windowEmail;
    private static VirtualMachine data;
    
    @BeforeClass(description = "open and enter calculator, open email in new window, sent results of calculator to email")
    public void openEstimatePageAndEmail() {
        data = VirtualMachineCreator.defaultMachine();
        windowGoogleCloud = GoogleCloudService.getEstimatePage(data);
        Tabs.openNew();
        windowEmail = YopmailService.openGeneratedEmail();
        String email = windowEmail.getEmailAddress();
        Tabs.goTo(0);
        windowGoogleCloud.sendByEmail(email);
    }
    
    @Test(description = "compares total cost in estimate on calculator and in email")
    public void checkTotalCostInCalculatorEqualsTotalCostInEmail() {
        String costFromGoogle = windowGoogleCloud.getTotalCost();
        Tabs.goTo(1);
        String costFromEmail = windowEmail.openLastEmail().getTotalCost();
        Assert.assertTrue(costFromGoogle.contains(costFromEmail), "expected " + costFromGoogle + " actual " + costFromEmail);
    }
}
