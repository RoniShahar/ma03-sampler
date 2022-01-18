package workspace.theConstantSampler.write;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.load.LoadConfiguration;

import javax.xml.bind.annotation.XmlRootElement;
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

    @Override
    public void setPath(String path) {
       super.path = path;
    }

    @Override
    public void write() throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new java.io.File(super.path + ".xml"), super.list);
    }
}
