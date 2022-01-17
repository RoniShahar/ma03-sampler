package workspace.theConstantSampler.write;

import workspace.theConstantSampler.dataBase.DataBase;

import java.io.IOException;
import java.util.List;

public interface WriteFactory {

    void setList(List<DataBase> list);
    void write() throws IOException;
}
