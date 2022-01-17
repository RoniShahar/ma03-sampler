package workspace.theConstantSampler.write;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.load.LoadConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class WriteToJsonFile extends Write{

    protected ObjectMapper objectMapper;

    public WriteToJsonFile(List<DataBase> list) throws IOException {
        super(list);
        objectMapper = new ObjectMapper();
    }

    public void writeToJsonFile() throws IOException {
        Properties properties = new LoadConfiguration().loadConfiguration();
        int maxRowInFile = Integer.parseInt(properties.getProperty("MAX_ROW_IN_FILE"));
        List<DataBase> subList;
        int min = 0;

        for (int i = 0; i <= super.list.size() / maxRowInFile; i++) {
            min = Math.min(maxRowInFile*(i+1), super.list.size());
            subList = super.list.subList(maxRowInFile*i, min);
            for (int j = maxRowInFile*i; j < min; j++) {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new java.io.File("C://Users//Ronis//Desktop//txt//mada_reports" + i + ".json"), subList);
            }
        }

    }
}
