package workspace.theConstantSampler.dataBase;

import java.util.ArrayList;
import java.util.List;

public class ListOfLabTests implements DataBaseFactory{

    List<DataBase> labTests;

    @Override
    public void create() {
        labTests = new ArrayList<>();
    }

    @Override
    public void add(String[] values) {
        String idNum = values[0];
        String idType = values[1];
        String firstName = values[2];
        String lastName = values[3];
        String resultDate = values[4];
        String birthDate = values[5];
        String labCode = values[6];
        String stickerNumber = values[7];
        String resultTestCorona = values[8];
        String variant = values[9];
        String testType = values[10];

        this.labTests.add(new LabTest(idNum, idType, firstName, lastName, resultDate, birthDate,
                labCode, stickerNumber, resultTestCorona, variant, testType));
    }

    @Override
    public List<DataBase> get() {
        return this.labTests;
    }
}
