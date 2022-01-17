package workspace.theConstantSampler;

import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.DataBaseFactory;
import workspace.theConstantSampler.parse.ParseCsvFile;
import workspace.theConstantSampler.write.WriteToJsonFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ETLManager {

    protected HashMap<String, DataBaseFactory> map;

    public ETLManager(HashMap<String, DataBaseFactory> map) {
        this.map = map;
    }

    public void manage(String path) {

        ParseCsvFile parse = new ParseCsvFile(path, map);
        List<DataBase> list = null;

        try {
            list = parse.parseCsvFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            WriteToJsonFile write = new WriteToJsonFile(list);
            write.writeToJsonFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
