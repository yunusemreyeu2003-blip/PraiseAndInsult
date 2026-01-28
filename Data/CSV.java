package Data;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class CSV {
    String path;
    CSVWriter writer;

    public CSV(String path) throws IOException {
        this.path = path;
        this.writer = new CSVWriter(new FileWriter(path));
    }

    public void writeRow(String[] row) {
        writer.writeNext(row);
    }
}