package workspace.theConstantSampler.dataBase;

import java.util.List;

public interface DataBaseFactory {
    void create();
    void add(String[] values);
    List<DataBase> get();
}
