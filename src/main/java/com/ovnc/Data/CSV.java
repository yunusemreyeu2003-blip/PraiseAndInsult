package com.ovnc.Data;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSV implements AutoCloseable{
    private static CSV instance = null;

    String path;
    CSVWriter writer;
    String[] header = {
            "Zaman Damgası",
            "Övgü/Hakaret",
            "Övgü/Hakaret Metni",
            "Kırmızı/Mavi",
            "Erken Basma",
            "Tepki Süresi",
            "Hatalı Basma",
            "Beyaz Ekran Süresi"
    };

    private CSV() {}

    public static synchronized CSV getInstance()
    {
        if (instance == null) {
            instance = new CSV();
        }
        return instance;
    }

    public void open(String path) {
        this.path = path;
        try {
            this.writer = new CSVWriter(new FileWriter(path, true));
            File file = new File(path);
            if (file.length() == 0) {
                writer.writeNext(header);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void writeRow(String[] row) {

        writer.writeNext(row);
    }

    @Override
    public void close() {
        try {
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}