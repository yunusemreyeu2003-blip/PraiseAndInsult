package Data;

import java.util.Arrays;

public class Data {
    public TestData[] warmupData = new TestData[3];

    public Data() {
        Arrays.fill(warmupData, new TestData());
    }
}