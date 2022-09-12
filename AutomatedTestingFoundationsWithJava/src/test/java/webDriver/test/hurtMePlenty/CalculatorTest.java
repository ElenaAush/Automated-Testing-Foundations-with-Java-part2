package webDriver.test.hurtMePlenty;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webDriver.page.cloudGoogle.GoogleCloudEstimatePage;
import webDriver.test.BaseTest;
import webDriver.service.GoogleCloudService;

public class CalculatorTest extends BaseTest {
    private GoogleCloudEstimatePage googleCloudWindow;
    
    @BeforeClass(description = "search calculator and add data")
    public void enterCalculator() {
        googleCloudWindow = GoogleCloudService.getEstimatePage();
    }
    
    @Test(description = "checks if the region is contains \"Frankfurt\"")
    public void checkRegion() {
        Assert.assertTrue(googleCloudWindow.getRegion().contains("Frankfurt"));
    }
    
    @Test(description = "check if the commitment term is contains \"1 Year\"")
    public void checkCommitmentTerm() {
        Assert.assertTrue(googleCloudWindow.getCommitmentTerm().contains("1 Year"));
    }
    
    @Test(description = "check if the provisioning model is contains \"Regular\"")
    public void checkProvisioningModel() {
        Assert.assertTrue(googleCloudWindow.getProvisioningModel().contains("Regular"));
    }
    
    @Test(description = "check if the instance type is contains \"n1-standard-8\"")
    public void checkInstanceType() {
        Assert.assertTrue(googleCloudWindow.getInstanceType().contains("n1-standard-8"));
    }
    
    @Test(description = "check if the localSSD is contains \"2x375\"")
    public void checkLocalSSD() {
        Assert.assertTrue(googleCloudWindow.getLocalSSD().contains("2x375"));
    }
}
