package workspace.theConstantSampler.load;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadConfiguration extends Load{

    public LoadConfiguration() {
        super("src/main/resources/Properties.properties");
    }

    public Properties loadConfiguration() throws IOException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(super.path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties prop = new Properties();
        prop.load(fileInputStream);
        return prop;
    }
}
