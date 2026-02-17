package com.ovnc.Data;

import java.time.OffsetDateTime;
import java.time.ZoneId;

public class Data {
    public TestData[] warmupData = new TestData[Config.WARMUP_COUNT];
    public TestData[] controlData = new TestData[Config.CONTROL_TEST_COUNT];
    public TestData[] experimentData = new TestData[Config.EXPERIMENT_TEST_COUNT];

    public Praise_InsultType praise_insult = null;
    public OffsetDateTime timestamp;

    public Data() {
        timestamp = OffsetDateTime.now(ZoneId.systemDefault());

        for (int i = 0; i < warmupData.length; i++) {
            warmupData[i] = new TestData();
        }
        for (int i = 0; i < controlData.length; i++) {
            controlData[i] = new TestData();
        }
        for (int i = 0; i < experimentData.length; i++) {
            experimentData[i] = new TestData();
        }

        if (Math.random() < 0.5) {
            praise_insult = Praise_InsultType.PRAISE;
        } else {
            praise_insult = Praise_InsultType.INSULT;
        }
    }

    public void writeToCSV() {
        CSV csv = CSV.getInstance();
        csv.open("data.csv");
        for(TestData testData : controlData) {
            csv.writeRow(formatDataRow(testData));
        }
        for(TestData testData : experimentData) {
            csv.writeRow(formatDataRow(testData));
        }
        csv.close();
    }

    private String[] formatDataRow(TestData testData) {
        String[] row = new String[8];
        row[0] = timestamp.toString();
        row[1] = testData.praise_insult == null ? "Kontrol" :
                (testData.praise_insult.type == Praise_InsultType.PRAISE ? "Övgü" : "Hakaret");
        row[2] = testData.praise_insult == null ? "null" :
                testData.praise_insult.text;
        row[3] = testData.triggerType == TriggerType.TRIGGER ? "Kırmızı" : "Mavi";
        row[4] = testData.earlyPress ? "Evet" : "Hayır";
        row[5] = testData.reactionTime == null ? "null" : String.valueOf(testData.reactionTime.toMillis());
        row[6] = testData.falsePress ? "Evet" : "Hayır";
        row[7] = testData.waitTime == null ? "null" : String.valueOf(testData.waitTime.toMillis());
        return row;
    }
}