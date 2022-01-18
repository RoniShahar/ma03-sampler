package workspace.theConstantSampler.write;

import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.load.LoadConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class WriteToXmlFileWithQuantityRestriction extends WriteToXmlFile{

    @Override
    public void write() throws IOException {
        Properties properties = new LoadConfiguration().loadConfiguration();
        int maxRowInFile = Integer.parseInt(properties.getProperty("MAX_ROW_IN_FILE"));

        List<DataBase> labTests;
        int min = 0;

        for (int i = 0; i <= super.list.size() / maxRowInFile; i++) {
            min = Math.min(maxRowInFile*(i+1), super.list.size());
            labTests = super.list.subList(maxRowInFile*i, min);
            for (int j = maxRowInFile*i; j < min; j++) {
                mapper.writerWithDefaultPrettyPrinter().writeValue(new java.io.File(super.path + i + ".xml"), labTests);
            }
        }
    }
}
