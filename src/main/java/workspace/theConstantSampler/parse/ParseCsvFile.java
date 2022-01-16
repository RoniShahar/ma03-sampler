package workspace.theConstantSampler.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class ParseCsvFile extends Parse{

    /*final static String COMMA_DELIMITER = ",";

    public ParseCsvFile(String path, HashMap<String, DataBaseFactory> map) {
        super(path, map);
    }

    public List<DataBase> parseCsvFile() throws IOException {
        List<DataBase> list = map.get(super.path).create();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new LoadCsvFile(super.path).loadCsvFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] record = line.split(COMMA_DELIMITER);
                map.get(super.path).add(record);
            }
        }

        return map.get(super.path).get();
    }*/
}
