package workspace.theConstantSampler.dataBase;

import java.util.List;

public interface DataBaseFactory {
    List<DataBase> create();
    void add(String[] values);
    List<DataBase> get();
}
