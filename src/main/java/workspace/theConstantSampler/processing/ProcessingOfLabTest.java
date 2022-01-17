package workspace.theConstantSampler.processing;

import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;
import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.LabTest;
import workspace.theConstantSampler.dataBase.TransformLabTest;

import java.util.ArrayList;
import java.util.List;

public class ProcessingOfLabTest {

    List<DataBase> extendedLabTests;

    public List<DataBase> processingOfLabTest(List<DataBase> labTests){
        extendedLabTests = new ArrayList<>();
        HealthCareInfoProvider healthCareInfoProvider = new HealthCareInfoProvider();

        for (DataBase labtest: labTests) {
            if(labtest instanceof LabTest){
                try {
                    LabTest test = ((LabTest) labtest);
                    PersonInsured person = healthCareInfoProvider.fetchInfo(Integer.parseInt(test.getIdNum()),
                            Integer.parseInt(test.getIdType()));
                    extendedLabTests.add(new TransformLabTest(test.getIdNum(), test.getIdType(), test.getFirstName(), test.getLastName(),
                            test.getResultDate(), test.getBirthDate(), test.getLabcode(), test.getStickerNumber(),
                            test.getResultTestCorona(), test.getVariant(), test.getTestType(), person.getJoinDate(),
                            person.getHealthCareId(), person.getHealthCareName()));
                } catch (InvalidIdException e) {
                    e.printStackTrace();
                }
            }
        }

        return this.extendedLabTests;
    }
}
