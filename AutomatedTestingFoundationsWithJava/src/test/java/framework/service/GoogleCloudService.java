package framework.service;

import framework.model.DataForCalculator;
import framework.page.cloudGoogle.GoogleCloudEstimatePage;
import framework.page.cloudGoogle.GoogleCloudHomePage;

public class GoogleCloudService {
    private static DataForCalculator data;
    
    public static GoogleCloudEstimatePage getEstimatePage() {
        data = DataForCalculatorCreator.getVersion1();
        return new GoogleCloudHomePage()
                .searchByRequest("Google Cloud Platform Pricing Calculator")
                .chooseCalculator()
                .chooseSectionComputeEngine()
                .enterDateToCalculator(data)
                .addToEstimate();
    }
}
