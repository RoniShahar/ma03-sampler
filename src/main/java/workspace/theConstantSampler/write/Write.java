package workspace.theConstantSampler.write;

import workspace.theConstantSampler.dataBase.DataBase;

import java.io.IOException;
import java.util.List;

public abstract class Write {

    protected List<DataBase> list;

    public Write() {
        this.list = null;
    }
}
