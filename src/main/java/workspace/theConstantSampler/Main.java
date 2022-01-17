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

        ETLManager manager = new ETLManager(map);
        manager.manage("src/main/resources/MadaReports.csv");
    }
}
