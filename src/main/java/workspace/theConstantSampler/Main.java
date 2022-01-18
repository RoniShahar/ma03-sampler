package workspace.theConstantSampler;

import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.DataBaseFactory;
import workspace.theConstantSampler.dataBase.ListOfLabTests;
import workspace.theConstantSampler.dataBase.ListOfMadaResults;
import workspace.theConstantSampler.parse.ParseCsvFile;
import workspace.theConstantSampler.parse.ParseFactory;
import workspace.theConstantSampler.processing.ProcessingFactory;
import workspace.theConstantSampler.processing.ProcessingOfLabTest;
import workspace.theConstantSampler.processing.ProcessingOfPatientsLivingDetails;
import workspace.theConstantSampler.write.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        HashMap<String, DataBaseFactory> dataBases = new HashMap<>() {{
            put("src/main/resources/MadaReports.csv", new ListOfMadaResults());
            put("src/main/resources/LabTests.csv", new ListOfLabTests());
        }};

        //related to part b
        HashMap<String, ProcessingFactory> dataBasesThatNeedTransform = new HashMap<>() {{
           // put("src/main/resources/LabTests.csv", new ProcessingOfLabTest());
        }};

        HashMap<String, WriteFactory> writers = new HashMap<>() {{
            put("src/main/resources/MadaReports.csv", new WriteToJsonFileWithQuantityRestriction());
            put("src/main/resources/LabTests.csv", new WriteToXmlFileWithQuantityRestriction());
        }};

        HashMap<String, ParseFactory> parsers = new HashMap<>() {{
            put("src/main/resources/MadaReports.csv", new ParseCsvFile());
            put("src/main/resources/LabTests.csv", new ParseCsvFile());
        }};

        //related to part a + b
        ETLManager manager = new ETLManager(dataBases, dataBasesThatNeedTransform, writers, parsers);
        //manager.manage("src/main/resources/MadaReports.csv", "C://Users//Ronis//Desktop//txt//mada_reports");
        //manager.manage("src/main/resources/LabTests.csv", "C://Users//Ronis//Desktop//txt//LABTESTS");

        List<List<DataBase>> madaResultsAndLabTests = new ArrayList<>();
        madaResultsAndLabTests.add(manager.manage("src/main/resources/MadaReports.csv", ""));
        madaResultsAndLabTests.add(manager.manage("src/main/resources/LabTests.csv", ""));

        //related to part c
        ProcessingOfPatientsLivingDetails processingOfPatientsLivingDetails = new ProcessingOfPatientsLivingDetails();
        List<DataBase> crossInformation = processingOfPatientsLivingDetails.Transfrom(madaResultsAndLabTests);
        WriteToJsonFileWithPlaceRestriction write = new WriteToJsonFileWithPlaceRestriction();
        write.setPath("C://Users//Ronis//Desktop//txt//POSITIVE_CORONA_PEOPLE");
        write.setList(crossInformation);
        try {
            write.write();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
