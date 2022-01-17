package workspace.theConstantSampler.parse;

import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.DataBaseFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ParseFactory {

    void setPath(String path);
    void setMap(Map<String , DataBaseFactory> map);
    List<DataBase> parse() throws IOException;
}

