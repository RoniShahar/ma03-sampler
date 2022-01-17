package workspace.theConstantSampler.write;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.load.LoadConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class WriteToJsonFile extends Write implements WriteFactory{

    protected ObjectMapper objectMapper;

    public WriteToJsonFile() {
        super();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void setList(List<DataBase> list) {
        super.list = list;
    }

    @Override
    public void write() throws IOException {
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
