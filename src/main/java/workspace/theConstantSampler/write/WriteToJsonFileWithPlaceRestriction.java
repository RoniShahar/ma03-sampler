package workspace.theConstantSampler.write;

import workspace.theConstantSampler.dataBase.LabTest;
import workspace.theConstantSampler.load.LoadConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class WriteToJsonFileWithPlaceRestriction extends WriteToJsonFile{

    @Override
    public void write() throws IOException {
        /*Properties properties = new LoadConfiguration().loadConfiguration();
        int maxFileSize = Integer.parseInt(properties.getProperty("MAX_FILE_SIZE"));
        int numOfRequiredFiles = 0;
        int numOfObjInList = 0;
        File file = null;

        int x =

       // Long x = new Byte(super.list.size());
       // int y =5;
        // mapper.writerWithDefaultPrettyPrinter().writeValue(new java.io.File(super.path + i + ".xml"), labTests);

        /*File file = new File("D:/test.txt");
        String data = "This is just a test !";
        int dataLength = data.getBytes("UTF-8").length;

        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath())) {
            while (file.length() + dataLength < ONE_KB) {
                writer.write(data);
                writer.flush();
            }
            System.out.println("1 KB Data written to the file.!");
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }
}
