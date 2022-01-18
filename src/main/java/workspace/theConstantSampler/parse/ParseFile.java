package workspace.theConstantSampler.parse;

import workspace.theConstantSampler.dataBase.DataBaseFactory;

import java.util.HashMap;
import java.util.Map;

public class ParseFile extends ParseObject {
    protected String path;
    protected Map<String , DataBaseFactory> map;

    public ParseFile() {
        this.path = null;
        this.map = null;
    }
}
