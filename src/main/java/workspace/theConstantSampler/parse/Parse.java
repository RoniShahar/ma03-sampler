package workspace.theConstantSampler.parse;

import workspace.theConstantSampler.dataBase.DataBaseFactory;

import java.util.HashMap;
import java.util.Map;

public class Parse {
    protected String path;
    protected Map<String , DataBaseFactory> map;

    public Parse(String path, HashMap<String, DataBaseFactory> map) {
        this.path = path;
        this.map = map;
    }
}
