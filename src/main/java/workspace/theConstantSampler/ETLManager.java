package workspace.theConstantSampler;

import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.DataBaseFactory;
import workspace.theConstantSampler.parse.ParseFactory;
import workspace.theConstantSampler.processing.ProcessingFactory;
import workspace.theConstantSampler.write.WriteFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<DataBase> manage(String filepath, String writePath) {

        List<List<DataBase>> allLists = new ArrayList<>();
        List<DataBase> list = null;

        try {
            this.parsers.get(filepath).setPath(filepath);
            this.parsers.get(filepath).setMap(dataBases);
            list = this.parsers.get(filepath).parse();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO exception, couldn't finish read the file");
        }

        if(this.dataBasesThatNeedTransform.containsKey(filepath)){
            allLists.add(list);
            list = this.dataBasesThatNeedTransform.get(filepath).Transfrom(allLists);
        }

        try {
            if(writePath != "") {
                this.writers.get(filepath).setList(list);
                this.writers.get(filepath).setPath(writePath);
                this.writers.get(filepath).write();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO exception, couldn't finish write the file");
        }

        return list;
    }
}
