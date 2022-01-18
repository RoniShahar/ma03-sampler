package workspace.theConstantSampler.write;

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
    public void setPath(String path) {
        super.path = path;
    }

    @Override
    public void write() throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new java.io.File(super.path + ".json"), super.list);
    }

}
