package Data;

import java.util.Arrays;

public class Data {
    public TestData[] warmupData = new TestData[Config.WARMUP_COUNT];
    public TestData[] controlData = new TestData[Config.CONTROL_TEST_COUNT];
    public TestData[] experimentData = new TestData[Config.EXPERIMENT_TEST_COUNT];


    public Data() {
        for (int i = 0; i < warmupData.length; i++) {
            warmupData[i] = new TestData();
        }
        for (int i = 0; i < controlData.length; i++) {
            controlData[i] = new TestData();
        }
        for (int i = 0; i < experimentData.length; i++) {
            experimentData[i] = new TestData();
        }
    }

    public void printWarmupData() {
        System.out.println("Warmup Data:");
        for (int i = 0; i < warmupData.length; i++) {
            System.out.println("Test " + (i + 1) + ": " +
                    " TriggerType=" +
                    warmupData[i].triggerType +
                    ", EarlyPress=" +
                    warmupData[i].earlyPress +
                    ", ReactionTime=" +
                    (warmupData[i].reactionTime == null ? "null" : warmupData[i].reactionTime.toMillis()) +
                    ", FalsePress=" +
                    warmupData[i].falsePress +
                    ", WaitTime=" +
                    (warmupData[i].waitTime == null ? "null" : warmupData[i].waitTime.toMillis()) +
                    ", FalsePressWaitTime=" +
                    (warmupData[i].FalsePressWaitTime == null ? "null" : warmupData[i].FalsePressWaitTime.toMillis())

            );
        }
    }

    public void printControlData() {
        System.out.println("\nControl Data:");
        for (int i = 0; i < controlData.length; i++) {
            System.out.println("Test " + (i + 1) + ": " +
                    " TriggerType=" +
                    controlData[i].triggerType +
                    ", EarlyPress=" +
                    controlData[i].earlyPress +
                    ", ReactionTime=" +
                    (controlData[i].reactionTime == null ? "null" : controlData[i].reactionTime.toMillis()) +
                    ", FalsePress=" +
                    controlData[i].falsePress +
                    ", WaitTime=" +
                    (controlData[i].waitTime == null ? "null" : controlData[i].waitTime.toMillis()) +
                    ", FalsePressWaitTime=" +
                    (controlData[i].FalsePressWaitTime == null ? "null" : controlData[i].FalsePressWaitTime.toMillis())
            );
        }
    }

    public void printExperimentData() {
        System.out.println("\nExperiment Data:");
        for (int i = 0; i < experimentData.length; i++) {
            System.out.println("Test " + (i + 1) + ": " +
                    " TriggerType=" +
                    experimentData[i].triggerType +
                    ", EarlyPress=" +
                    experimentData[i].earlyPress +
                    ", ReactionTime=" +
                    (experimentData[i].reactionTime == null ? "null" : experimentData[i].reactionTime.toMillis()) +
                    ", FalsePress=" +
                    experimentData[i].falsePress +
                    ", WaitTime=" +
                    (experimentData[i].waitTime == null ? "null" : experimentData[i].waitTime.toMillis()) +
                    ", FalsePressWaitTime=" +
                    (experimentData[i].FalsePressWaitTime == null ? "null" : experimentData[i].FalsePressWaitTime.toMillis())

            );
        }
    }
}