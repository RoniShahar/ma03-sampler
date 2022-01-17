package workspace.theConstantSampler;

import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.DataBaseFactory;
import workspace.theConstantSampler.parse.ParseCsvFile;
import workspace.theConstantSampler.processing.ProcessingFactory;
import workspace.theConstantSampler.write.WriteFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ETLManager {

    protected HashMap<String, DataBaseFactory> dataBases;
    protected HashMap<String, ProcessingFactory> dataBasesThatNeedTransform;
    protected HashMap<String, WriteFactory> writers;

    public ETLManager(HashMap<String, DataBaseFactory> dataBases, HashMap<String, ProcessingFactory>
            dataBasesThatNeedTransform, HashMap<String, WriteFactory> writers) {
        this.dataBases = dataBases;
        this.dataBasesThatNeedTransform = dataBasesThatNeedTransform;
        this.writers = writers;
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
            this.writers.get(path).setList(list);
            this.writers.get(path).write();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO exception, couldn't finish write the file");
        }
    }
}
