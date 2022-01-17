package workspace.theConstantSampler;

import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.DataBaseFactory;
import workspace.theConstantSampler.parse.ParseCsvFile;
import workspace.theConstantSampler.parse.ParseFactory;
import workspace.theConstantSampler.processing.ProcessingFactory;
import workspace.theConstantSampler.write.WriteFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ETLManager {

    protected HashMap<String, DataBaseFactory> dataBases;
    protected HashMap<String, ProcessingFactory> dataBasesThatNeedTransform;
    protected HashMap<String, WriteFactory> writers;
    protected HashMap<String, ParseFactory> parsers;

    public ETLManager(HashMap<String, DataBaseFactory> dataBases, HashMap<String, ProcessingFactory>
            dataBasesThatNeedTransform, HashMap<String, WriteFactory> writers, HashMap<String, ParseFactory> parsers) {
        this.dataBases = dataBases;
        this.dataBasesThatNeedTransform = dataBasesThatNeedTransform;
        this.writers = writers;
        this.parsers = parsers;
    }

    public void manage(String path) {

        List<DataBase> list = null;

        try {
            this.parsers.get(path).setPath(path);
            this.parsers.get(path).setMap(dataBases);
            list = this.parsers.get(path).parse();
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
