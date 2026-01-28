import com.opencsv.CSVWriter;

public class CSV {
    String file;
    CSVWriter writer;

    public CSV(String file) {
        this.file = file;
        this.writer = new CSVWriter(file);
    }

    public void writeRow(String[] row) {
        writer.writeNext(row);
    }
}