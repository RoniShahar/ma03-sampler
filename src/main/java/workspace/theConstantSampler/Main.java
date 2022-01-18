package workspace.theConstantSampler;

import workspace.theConstantSampler.dataBase.DataBaseFactory;
import workspace.theConstantSampler.dataBase.ListOfLabTests;
import workspace.theConstantSampler.dataBase.ListOfMadaResults;
import workspace.theConstantSampler.parse.ParseCsvFile;
import workspace.theConstantSampler.parse.ParseFactory;
import workspace.theConstantSampler.processing.Processing;
import workspace.theConstantSampler.processing.ProcessingFactory;
import workspace.theConstantSampler.processing.ProcessingOfLabTest;
import workspace.theConstantSampler.write.Write;
import workspace.theConstantSampler.write.WriteFactory;
import workspace.theConstantSampler.write.WriteToJsonFile;
import workspace.theConstantSampler.write.WriteToXmlFile;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, DataBaseFactory> dataBases = new HashMap<>() {{
            put("src/main/resources/MadaReports.csv", new ListOfMadaResults());
            put("src/main/resources/LabTests.csv", new ListOfLabTests());
        }};

        HashMap<String, ProcessingFactory> dataBasesThatNeedTransform = new HashMap<>() {{
            put("src/main/resources/LabTests.csv", new ProcessingOfLabTest());
        }};

        HashMap<String, WriteFactory> writers = new HashMap<>() {{
            put("src/main/resources/MadaReports.csv", new WriteToXmlFile());
            put("src/main/resources/LabTests.csv", new WriteToXmlFile());
        }};

        HashMap<String, ParseFactory> parsers = new HashMap<>() {{
            put("src/main/resources/MadaReports.csv", new ParseCsvFile());
            put("src/main/resources/LabTests.csv", new ParseCsvFile());
        }};

        ETLManager manager = new ETLManager(dataBases, dataBasesThatNeedTransform, writers, parsers);
        //manager.manage("src/main/resources/MadaReports.csv");
        manager.manage("src/main/resources/LabTests.csv");
    }
}
