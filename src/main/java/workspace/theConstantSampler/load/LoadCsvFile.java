package workspace.theConstantSampler.load;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LoadCsvFile extends Load{

    public LoadCsvFile(String path) {
        super(path);
    }

    public InputStream loadCsvFile(){
        InputStream input = null;

        try {
            input = new FileInputStream(new File(super.path));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
