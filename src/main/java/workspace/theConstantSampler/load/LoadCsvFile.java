package workspace.theConstantSampler.load;

import java.io.*;

public class LoadCsvFile extends Load{

    public LoadCsvFile(String path) {
        super(path);
    }

    public InputStream loadCsvFile() throws FileNotFoundException {
        InputStream input = new FileInputStream(super.path);
        return input;
    }
}
