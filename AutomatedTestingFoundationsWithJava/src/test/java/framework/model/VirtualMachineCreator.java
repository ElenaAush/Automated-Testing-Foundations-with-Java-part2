package framework.model;

import framework.util.TestDataReader;

public class VirtualMachineCreator {
    
    public static String TESTDATA_NUMBER_OF_INSTANCES = "testdata.number_of_instances";
    public static String TESTDATA_OPERATION_SYSTEM = "testdata.operation_system";
    public static String TESTADTA_PROVISIONING_MODEL = "testdata.provisioning_model";
    public static String TESTDATA_SERIES = "testdata.series";
    public static String TESTDATA_MACHINE_TYPE = "testdata.machine_type";
    public static String TESTDATA_GPU_TYPE = "testdata.GPU_type";
    public static String TESTDATA_NUMBER_OF_GPUS = "testdata.number_of_GPUs";
    public static String TESTDATA_LOCAL_SSD = "testdata.local_ssd";
    public static String TESTDATA_DATACENTER_LOCATION = "testdata.datacenter_location";
    public static String TESTDATA_COMMITTED_USAGE = "testdata.committed_usage";
    
    public static VirtualMachine defaultMachine() {
        return new VirtualMachine(Integer.parseInt(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES)),
                TestDataReader.getTestData(TESTDATA_OPERATION_SYSTEM),
                TestDataReader.getTestData(TESTADTA_PROVISIONING_MODEL),
                TestDataReader.getTestData(TESTDATA_SERIES),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS)),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE));
    }
}
