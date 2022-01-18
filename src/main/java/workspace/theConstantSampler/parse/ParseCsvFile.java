package workspace.theConstantSampler.parse;

import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.DataBaseFactory;
import workspace.theConstantSampler.load.LoadCsvFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseCsvFile extends ParseFile implements ParseFactory{

    final static String COMMA_DELIMITER = ",";

    public ParseCsvFile() {
        super();
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void setMap(Map<String, DataBaseFactory> map) {
        this.map = map;
    }

    public List<DataBase> parse() throws IOException {
        map.get(super.path).create();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new LoadCsvFile(super.path).loadCsvFile()))) {
            String line;
            Boolean isHeaderLine = true;
            while ((line = br.readLine()) != null) {
                String[] record = line.split(COMMA_DELIMITER);
                int x = record.length;
                //if it is header line, don't add it to the list.
                if(isHeaderLine) {
                    isHeaderLine = false;
                } else {
                    map.get(super.path).add(record);
                }
            }
        }

        return map.get(super.path).get();
    }
}
