package workspace.theConstantSampler.load;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadConfiguration extends LoadFile{

    public LoadConfiguration() {
        super("src/main/resources/Properties.properties");
    }

    /**
     * @return - Properties object that contain the data from the configuration file.
     * @throws IOException
     */
    public Properties loadConfiguration() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(super.path);
        Properties prop = new Properties();
        prop.load(fileInputStream);
        return prop;
    }
}
