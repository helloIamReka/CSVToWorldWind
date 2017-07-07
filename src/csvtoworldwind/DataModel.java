package csvtoworldwind;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.*;

public class DataModel {

    private ArrayList<LatLong> latitudeLongitudeList = new ArrayList<>();
    private FileReader fileReader = null;
    private CSVParser csvFileParser = null;
    private CSVFormat csvFileFormat = CSVFormat.DEFAULT;        // Assuming there is no header!

    public void readFile(File csvFile) throws FileNotFoundException, IOException {
        fileReader = new FileReader(csvFile);
        csvFileParser = new CSVParser(fileReader, csvFileFormat);
        List csvRecords = csvFileParser.getRecords();
        compileList(csvRecords);
    }

    private void compileList(List csvRecords) {
        for (int i = 0; i < csvRecords.size(); i++) {       // if there is a header, i should start counting at 1
            CSVRecord record = (CSVRecord) csvRecords.get(i);
            LatLong latLongInstance = new LatLong(Double.parseDouble(record.get(0)), Double.parseDouble(record.get(1)));
            latitudeLongitudeList.add(latLongInstance);
            doTheMagic(latitudeLongitudeList);
        }
    }

    private void doTheMagic(ArrayList<LatLong> latitudeLongitudeList) {

        // TODO: make these points appear on the World Wind
    }
}
