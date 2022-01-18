package workspace.theConstantSampler.write;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.load.LoadConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class WriteToXmlFile extends Write implements WriteFactory{

    protected XmlMapper mapper;

    public WriteToXmlFile() {
        super();
        mapper = new XmlMapper();
    }

    @Override
    public void setList(List<DataBase> list) {
        super.list = list;
    }

    public void write() throws IOException {
        Properties properties = new LoadConfiguration().loadConfiguration();
        int maxRowInFile = Integer.parseInt(properties.getProperty("MAX_ROW_IN_FILE"));
        List<DataBase> labTests;
        int min = 0;

        for (int i = 0; i <= super.list.size() / maxRowInFile; i++) {
            min = Math.min(maxRowInFile*(i+1), super.list.size());
            labTests = super.list.subList(maxRowInFile*i, min);
            for (int j = maxRowInFile*i; j < min; j++) {
               mapper.writerWithDefaultPrettyPrinter().writeValue(new java.io.File("C://Users//Ronis//Desktop//txt//LABTESTS" + i + ".xml"), labTests);
            }
        }
    }
}
