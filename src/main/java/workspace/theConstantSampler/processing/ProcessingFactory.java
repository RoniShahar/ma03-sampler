package workspace.theConstantSampler.processing;

import workspace.theConstantSampler.dataBase.DataBase;

import java.util.List;

public interface ProcessingFactory {

    List<DataBase> Transfrom(List<List<DataBase>> list);
}
