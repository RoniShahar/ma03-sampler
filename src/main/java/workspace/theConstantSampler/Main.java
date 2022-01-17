package workspace.theConstantSampler;

import workspace.theConstantSampler.dataBase.DataBaseFactory;
import workspace.theConstantSampler.dataBase.ListOfMadaResults;
import workspace.theConstantSampler.processing.Processing;
import workspace.theConstantSampler.processing.ProcessingFactory;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, DataBaseFactory> dataBases = new HashMap<>() {{
            put("src/main/resources/MadaReports.csv", new ListOfMadaResults());
        }};

        HashMap<String, ProcessingFactory> dataBasesThatNeedTransform = new HashMap<>() {{
            //put("src/main/resources/MadaReports.csv", new ProcessingOfMadaResult());
        }};

        ETLManager manager = new ETLManager(dataBases, dataBasesThatNeedTransform);
        manager.manage("src/main/resources/MadaReports.csv");
    }
}
