package workspace.theConstantSampler;

import workspace.theConstantSampler.dataBase.DataBaseFactory;
import workspace.theConstantSampler.dataBase.ListOfMadaResults;
import workspace.theConstantSampler.processing.Processing;
import workspace.theConstantSampler.processing.ProcessingFactory;
import workspace.theConstantSampler.write.Write;
import workspace.theConstantSampler.write.WriteFactory;
import workspace.theConstantSampler.write.WriteToJsonFile;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, DataBaseFactory> dataBases = new HashMap<>() {{
            put("src/main/resources/MadaReports.csv", new ListOfMadaResults());
            put("src/main/resources/LabTests.csv", new ListOfMadaResults());
        }};

        HashMap<String, ProcessingFactory> dataBasesThatNeedTransform = new HashMap<>() {{
            //put("src/main/resources/LabTests.csv", new ProcessingOfLabTests());
        }};

        HashMap<String, WriteFactory> writers = new HashMap<>() {{
            put("src/main/resources/LabTests.csv", new WriteToJsonFile());
        }};

        ETLManager manager = new ETLManager(dataBases, dataBasesThatNeedTransform, writers);
        //manager.manage("src/main/resources/MadaReports.csv");
        manager.manage("src/main/resources/LabTests.csv");
    }
}
