package webDriver.service;

import webDriver.page.cloudGoogle.GoogleCloudEstimatePage;
import webDriver.page.cloudGoogle.GoogleCloudHomePage;

public class GoogleCloudService {
    public static GoogleCloudEstimatePage getEstimatePage() {
        return new GoogleCloudHomePage()
                .searchByRequest("Google Cloud Platform Pricing Calculator")
                .chooseCalculator()
                .chooseSectionComputeEngine()
                .enterToInstances(4, "Free", "Regular",
                        "N1", "n1-standard-8")
                .addCPUs("NVIDIA Tesla V100", 1, "2x375",
                        "Frankfurt (europe-west3)", "1 Year")
                .addToEstimate();
    }
}
