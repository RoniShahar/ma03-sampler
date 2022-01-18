package workspace.theConstantSampler.write;

import com.fasterxml.jackson.databind.ObjectMapper;
import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.LabTest;
import workspace.theConstantSampler.load.LoadConfiguration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Properties;

public class WriteToJsonFileWithPlaceRestriction extends WriteToJsonFile{

    @Override
    public void write() throws IOException {
        Properties properties = new LoadConfiguration().loadConfiguration();
        int maxFileSize = Integer.parseInt(properties.getProperty("MAX_FILE_SIZE"));
        int numOfFiles = 0;
        int numOfObjInList = 0;
        int numOfObjInLastFile = 0;
        File file = null;
        ObjectMapper mapper = new ObjectMapper();
        List<DataBase> subList = super.list.subList(numOfObjInLastFile, numOfObjInList);

        while (numOfObjInList < super.list.size()) {
            file = new File(super.path + numOfFiles + ".json");
            numOfObjInLastFile = numOfObjInList;
            try (BufferedWriter writer = Files.newBufferedWriter(file.toPath())) {
                while (file.length() < maxFileSize && numOfObjInList < super.list.size()) {
                    writer.write(super.list.get(numOfObjInList).toString());
                    numOfObjInList++;
                    subList = super.list.subList(numOfObjInLastFile, numOfObjInList);
                }
                numOfFiles++;
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, subList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
