package workspace.theConstantSampler.processing;

import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;
import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.LabTest;
import workspace.theConstantSampler.dataBase.TransformLabTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProcessingOfLabTest implements ProcessingFactory{

    @Override
    public List<DataBase> Transfrom(List<List<DataBase>> list) {
        List<DataBase> extendedLabTests = new ArrayList<>();
        HealthCareInfoProvider healthCareInfoProvider = new HealthCareInfoProvider();

        for (DataBase labtest: list.get(0)) {
            if(labtest instanceof LabTest){
                try {
                    LabTest test = ((LabTest) labtest);
                    if(test.getIdNum().length() != 9){
                        System.out.println(test.getFirstName() + " " + test.getLastName() + " ID not valid");
                    } else {
                        PersonInsured person = healthCareInfoProvider.fetchInfo(Integer.parseInt(test.getIdNum()),
                                Integer.parseInt(test.getIdType()));
                        extendedLabTests.add(new TransformLabTest(test.getIdNum(), test.getIdType(), test.getFirstName(), test.getLastName(),
                                test.getResultDate(), test.getBirthDate(), test.getLabCode(), test.getStickerNumber(),
                                test.getResultTestCorona(), test.getVariant(), test.getTestType(), person.getJoinDate().toString(),
                                person.getHealthCareId(), person.getHealthCareName()));
                    }
                } catch (InvalidIdException e) {
                    e.printStackTrace();
                }
            }
        }

        return extendedLabTests;
    }
}
