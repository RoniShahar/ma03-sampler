package workspace.theConstantSampler;

import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.DataBaseFactory;
import workspace.theConstantSampler.parse.ParseCsvFile;
import workspace.theConstantSampler.processing.Processing;
import workspace.theConstantSampler.processing.ProcessingFactory;
import workspace.theConstantSampler.write.WriteToJsonFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ETLManager {

    protected HashMap<String, DataBaseFactory> dataBases;
    protected HashMap<String, ProcessingFactory> dataBasesThatNeedTransform;

    public ETLManager(HashMap<String, DataBaseFactory> dataBases, HashMap<String, ProcessingFactory>
            dataBasesThatNeedTransform) {
        this.dataBases = dataBases;
        this.dataBasesThatNeedTransform = dataBasesThatNeedTransform;
    }

    public void manage(String path) {

        ParseCsvFile parse = new ParseCsvFile(path, dataBases);
        List<DataBase> list = null;

        try {
            list = parse.parseCsvFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO exception, couldn't finish read the file");
        }

        if(this.dataBasesThatNeedTransform.containsKey(path)){
            list = this.dataBasesThatNeedTransform.get(path).Transfrom();
        }

        try {
            WriteToJsonFile write = new WriteToJsonFile(list);
            write.writeToJsonFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO exception, couldn't finish write the file");
        }
    }
}
