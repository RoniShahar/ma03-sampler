package workspace.theConstantSampler.write;

import workspace.theConstantSampler.dataBase.DataBase;

import java.io.IOException;
import java.util.List;

public class Write {

    protected List<DataBase> list;
    protected String path;

    public Write() {
        this.list = null;
        path = null;
    }
}
