package framework.page.cloudGoogle;

import framework.model.VirtualMachine;
import framework.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {
    
    private static final Logger log = LogManager.getRootLogger();
    
    private static final By elementsInDropListLocator = By.xpath("//*[@class='md-select-menu-container md-active md-clickable']//*[@role='option']");
    private static final By elementsInDropListDatacenterLocationLocator
            = By.xpath("//*[@class='md-select-menu-container cpc-region-select md-active md-clickable']//*[@role='option']");
    
    @FindBy(xpath = "//div[@title='Compute Engine'][1]")
    private WebElement computeEngineButton;
    
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstancesField;
    
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']//span[2]")
    private WebElement operationSystemDropList;
    
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']//span[2]")
    private WebElement provisioningModelDropList;
    
    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.series']//span[2]")
    private WebElement seriesDropList;
    
    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.instance']//span[2]")
    private WebElement machineTypeDropList;
    
    @FindBy(xpath = "(//md-checkbox[@aria-label='Add GPUs']/div)[1]")
    private WebElement CPUCheckbox;
    
    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement GPUTypeDropList;
    
    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numberOfGPUsDropList;
    
    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.ssd']//span[2]")
    private WebElement localSSDDropList;
    
    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.location']//span[2]")
    private WebElement datacenterLocationDropList;
    
    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.cud']//span[2]")
    private WebElement committedUsageDropList;
    
    @FindBy(xpath = "(//button[@aria-label='Add to Estimate'])[1]")
    private WebElement addToEstimateButton;
    
    public GoogleCloudPricingCalculatorPage chooseSectionComputeEngine() {
        switchFrames();
        computeEngineButton.click();
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage enterDateToCalculator(VirtualMachine data) {
        enterNumberOfInstances(data);
        chooseOperationSystem(data);
        chooseProvisionModel(data);
        chooseSeries(data);
        chooseMachineType(data);
        addGPU(data);
        chooseGPUType(data);
        chooseNumberOfGPUs(data);
        chooseLocalSSD(data);
        chooseDatacenterLocation(data);
        chooseCommittedUsage(data);
        return this;
    }
    
    public GoogleCloudEstimatePage addToEstimate() {
        addToEstimateButton.click();
        log.info("estimate was created");
        return new GoogleCloudEstimatePage();
    }
    
    public GoogleCloudPricingCalculatorPage enterNumberOfInstances(VirtualMachine data) {
        numberOfInstancesField.sendKeys(String.valueOf(data.getNumberOfInstances()));
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseOperationSystem(VirtualMachine data) {
        this.operationSystemDropList.click();
        clickOnElementFromDropList(data.getOperationSystem());
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseProvisionModel(VirtualMachine data) {
        this.provisioningModelDropList.click();
        clickOnElementFromDropList(data.getProvisioningModel());
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseSeries(VirtualMachine data) {
        this.seriesDropList.click();
        clickOnElementFromDropList(data.getSeries());
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseMachineType(VirtualMachine data) {
        this.machineTypeDropList.click();
        clickOnElementFromDropList(data.getMachineType());
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage addGPU(VirtualMachine data) {
        if (!CPUCheckbox.isSelected()) {
            CPUCheckbox.click();
        }
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseGPUType(VirtualMachine data) {
        this.GPUTypeDropList.click();
        clickOnElementFromDropList(data.getGPUType());
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseNumberOfGPUs(VirtualMachine data) {
        numberOfGPUsDropList.click();
        clickOnElementFromDropList(String.valueOf(data.getNumberOfGPUs()));
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseLocalSSD(VirtualMachine data) {
        this.localSSDDropList.click();
        clickOnElementFromDropList(data.getLocalSSD());
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseDatacenterLocation(VirtualMachine data) {
        this.datacenterLocationDropList.click();
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_SECONDS)).until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(elementsInDropListDatacenterLocationLocator));
        List<WebElement> elementsInDropList = driver.findElements(elementsInDropListDatacenterLocationLocator);
        
        for (WebElement web : elementsInDropList) {
            if (web.getText().contains(data.getDatacenterLocation())) {
                web.click();
                break;
            }
        }
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseCommittedUsage(VirtualMachine data) {
        this.committedUsageDropList.click();
        clickOnElementFromDropList(data.getCommittedUsage());
        return this;
    }
    
    private void switchFrames() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_SECONDS)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_SECONDS)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame"));
    }
    
    private void clickOnElementFromDropList(String element) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_SECONDS)).until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(elementsInDropListLocator));
        List<WebElement> elementsInDropList = driver.findElements(elementsInDropListLocator);
        
        for (WebElement web : elementsInDropList) {
            if (web.getText().contains(element)) {
                new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_SECONDS)).until(ExpectedConditions.elementToBeClickable(web));
                web.click();
                break;
            }
        }
    }
}
