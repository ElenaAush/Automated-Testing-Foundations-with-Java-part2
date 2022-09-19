package framework.service;

import framework.model.VirtualMachine;
import framework.page.cloudGoogle.GoogleCloudEstimatePage;
import framework.page.cloudGoogle.GoogleCloudHomePage;

public class GoogleCloudService {
    
    public static GoogleCloudEstimatePage getEstimatePage(VirtualMachine data) {
        return new GoogleCloudHomePage()
                .searchByRequest("Google Cloud Platform Pricing Calculator")
                .chooseCalculator()
                .chooseSectionComputeEngine()
                .enterDateToCalculator(data)
                .addToEstimate();
    }
}
