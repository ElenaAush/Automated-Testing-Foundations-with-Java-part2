package framework.model;

import java.util.Objects;

public class DataForCalculator {
    private int numberOfInstances;
    private String operationSystem;
    private String provisioningModel;
    private String series;
    private String machineType;
    private boolean isAddGPUs;
    private String GPUType;
    private int numberOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;
    
    public DataForCalculator(int numberOfInstances, String operationSystem, String provisioningModel, String series, String machineType,
                             boolean isAddGPUs, String GPUType, int numberOfGPUs, String localSSD, String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operationSystem = operationSystem;
        this.provisioningModel = provisioningModel;
        this.series = series;
        this.machineType = machineType;
        this.isAddGPUs = isAddGPUs;
        this.GPUType = GPUType;
        this.numberOfGPUs = numberOfGPUs;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }
    
    public int getNumberOfInstances() {
        return numberOfInstances;
    }
    
    public void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }
    
    public String getOperationSystem() {
        return operationSystem;
    }
    
    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }
    
    public String getProvisioningModel() {
        return provisioningModel;
    }
    
    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }
    
    public String getSeries() {
        return series;
    }
    
    public void setSeries(String series) {
        this.series = series;
    }
    
    public String getMachineType() {
        return machineType;
    }
    
    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }
    
    public boolean isAddGPUs() {
        return isAddGPUs;
    }
    
    public void setAddGPUs(boolean addGPUs) {
        isAddGPUs = addGPUs;
    }
    
    public String getGPUType() {
        return GPUType;
    }
    
    public void setGPUType(String GPUType) {
        this.GPUType = GPUType;
    }
    
    public int getNumberOfGPUs() {
        return numberOfGPUs;
    }
    
    public void setNumberOfGPUs(int numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }
    
    public String getLocalSSD() {
        return localSSD;
    }
    
    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }
    
    public String getDatacenterLocation() {
        return datacenterLocation;
    }
    
    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }
    
    public String getCommittedUsage() {
        return committedUsage;
    }
    
    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataForCalculator that = (DataForCalculator) o;
        return numberOfInstances == that.numberOfInstances
                && isAddGPUs == that.isAddGPUs
                && numberOfGPUs == that.numberOfGPUs
                && Objects.equals(operationSystem, that.operationSystem)
                && Objects.equals(provisioningModel, that.provisioningModel)
                && Objects.equals(series, that.series)
                && Objects.equals(machineType, that.machineType)
                && Objects.equals(GPUType, that.GPUType)
                && Objects.equals(localSSD, that.localSSD)
                && Objects.equals(datacenterLocation, that.datacenterLocation)
                && Objects.equals(committedUsage, that.committedUsage);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operationSystem, provisioningModel, series, machineType,
                isAddGPUs, GPUType, numberOfGPUs, localSSD, datacenterLocation, committedUsage);
    }
    
    @Override
    public String toString() {
        return "DataForCalculator{" +
                "numberOfInstances=" + numberOfInstances +
                ", operationSystem='" + operationSystem + '\'' +
                ", provisioningModel='" + provisioningModel + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", isAddGPUs=" + isAddGPUs +
                ", GPUType='" + GPUType + '\'' +
                ", numberOfGPUs=" + numberOfGPUs +
                ", localSSD='" + localSSD + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }
}
