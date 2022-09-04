package webDriver.page.cloudGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.page.AbstractPage;

import java.time.Duration;
import java.util.List;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {
    private static final By elementsInDropListLocator = By.xpath("//*[@class='md-select-menu-container md-active md-clickable']//*[@role='option']");
    private static final By elementsInDropListDatacenterLocationLocator = By.xpath("//*[@id='select_container_123']//*[@role='option']");
    
    @FindBy(xpath = "//div[@title='Compute Engine'][1]")
    private WebElement computeEngineButton;
    
    @FindBy(id = "input_89")
    private WebElement numberOfInstancesField;
    
    @FindBy(xpath = "//*[@id='select_value_label_81']/span[2]")
    private WebElement operationSystemDropList;
    
    @FindBy(xpath = "//*[@id='select_value_label_82']/span[2]")
    private WebElement provisioningModelDropList;
    
    @FindBy(xpath = "//*[@id='select_value_label_84']/span[2]")
    private WebElement seriesDropList;
    
    @FindBy(xpath = "//*[@id='select_value_label_85']/span[2]")
    private WebElement machineTypeDropList;
    
    @FindBy(xpath = "(//md-checkbox[@aria-label='Add GPUs']/div)[1]")
    private WebElement CPUCheckbox;
    
    @FindBy(id = "select_461")
    private WebElement GPUTypeDropList;
    
    @FindBy(id = "select_463")
    private WebElement numberOfGPUsDropList;
    
    @FindBy(xpath = "//*[@id='select_value_label_417']/span[2]")
    private WebElement localSSDDropList;
    
    @FindBy(id = "select_value_label_87")
    private WebElement datacenterLocationDropList;
    
    @FindBy(id = "select_value_label_88")
    private WebElement committedUsageDropList;
    
    @FindBy(xpath = "(//button[@aria-label='Add to Estimate'])[1]")
    private WebElement addToEstimateButton;
    
    public GoogleCloudPricingCalculatorPage chooseSectionComputeEngine() {
        switchFrames();
        computeEngineButton.click();
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage enterToInstances(int numberOfInstance, String operationSystem,
                                                             String provisioningModel, String series, String machineType) {
        enterNumberOfInstances(numberOfInstance);
        chooseOperationSystem(operationSystem);
        chooseProvisionModel(provisioningModel);
        chooseSeries(series);
        chooseMachineType(machineType);
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage addCPUs(String GPUType, int numberOfGPUs, String localSSD,
                                                    String datacenterLocation, String committedUsage) {
        if (!CPUCheckbox.isSelected()) {
            CPUCheckbox.click();
        }
        chooseGPUType(GPUType);
        chooseNumberOfGPUs(numberOfGPUs);
        chooseLocalSSD(localSSD);
        chooseDatacenterLocation(datacenterLocation);
        chooseCommittedUsage(committedUsage);
        return this;
    }
    
    public GoogleCloudEstimatePage addToEstimate() {
        addToEstimateButton.click();
        return new GoogleCloudEstimatePage();
    }
    
    public GoogleCloudPricingCalculatorPage enterNumberOfInstances(int instance) {
        numberOfInstancesField.sendKeys(String.valueOf(instance));
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseOperationSystem(String operationSystem) {
        this.operationSystemDropList.click();
        clickOnElementFromDropList(operationSystem);
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseProvisionModel(String provisioningModel) {
        this.provisioningModelDropList.click();
        clickOnElementFromDropList(provisioningModel);
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseSeries(String series) {
        this.seriesDropList.click();
        clickOnElementFromDropList(series);
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseMachineType(String machineType) {
        this.machineTypeDropList.click();
        clickOnElementFromDropList(machineType);
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseGPUType(String GPUType) {
        this.GPUTypeDropList.click();
        clickOnElementFromDropList(GPUType);
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseNumberOfGPUs(int number) {
        numberOfGPUsDropList.click();
        clickOnElementFromDropList(String.valueOf(number));
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseLocalSSD(String localSSD) {
        this.localSSDDropList.click();
        clickOnElementFromDropList(localSSD);
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseDatacenterLocation(String datacenterLocation) {
        this.datacenterLocationDropList.click();
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME_SECONDS)).until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(elementsInDropListDatacenterLocationLocator));
        List<WebElement> elementsInDropList = driver.findElements(elementsInDropListDatacenterLocationLocator);
        
        for (WebElement web : elementsInDropList) {
            if (web.getText().contains(datacenterLocation)) {
                web.click();
                break;
            }
        }
        return this;
    }
    
    public GoogleCloudPricingCalculatorPage chooseCommittedUsage(String committedUsage) {
        this.committedUsageDropList.click();
        clickOnElementFromDropList(committedUsage);
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
