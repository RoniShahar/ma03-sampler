package workspace.theConstantSampler;

import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.DataBaseFactory;
import workspace.theConstantSampler.dataBase.ListOfMadaResults;
import workspace.theConstantSampler.parse.ParseCsvFile;
import workspace.theConstantSampler.write.WriteToJsonFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HashMap<String, DataBaseFactory> map = new HashMap<>() {{
            put("src/main/resources/MadaReports.csv", new ListOfMadaResults());
        }};


        ParseCsvFile parse = new ParseCsvFile("src/main/resources/MadaReports.csv", map);
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
