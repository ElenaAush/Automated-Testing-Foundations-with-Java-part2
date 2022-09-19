package framework.model;

import java.util.Objects;

public class VirtualMachine {
    
    private int numberOfInstances;
    private String operationSystem;
    private String provisioningModel;
    private String series;
    private String machineType;
    private String GPUType;
    private int numberOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;
    
    public VirtualMachine(int numberOfInstances, String operationSystem, String provisioningModel, String series, String machineType,
                          String GPUType, int numberOfGPUs, String localSSD, String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operationSystem = operationSystem;
        this.provisioningModel = provisioningModel;
        this.series = series;
        this.machineType = machineType;
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
        VirtualMachine that = (VirtualMachine) o;
        return numberOfInstances == that.numberOfInstances
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
                GPUType, numberOfGPUs, localSSD, datacenterLocation, committedUsage);
    }
    
    @Override
    public String toString() {
        return "VirtualMachin{" +
                "numberOfInstances=" + numberOfInstances +
                ", operationSystem='" + operationSystem + '\'' +
                ", provisioningModel='" + provisioningModel + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", GPUType='" + GPUType + '\'' +
                ", numberOfGPUs=" + numberOfGPUs +
                ", localSSD='" + localSSD + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }
}
