package workspace.theConstantSampler.processing;

import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.LabTest;
import workspace.theConstantSampler.dataBase.MadaReport;
import workspace.theConstantSampler.dataBase.PatientsLivingDetails;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProcessingOfPatientsLivingDetails implements ProcessingFactory{

    @Override
    public List<DataBase> Transfrom(List<List<DataBase>> list) {
       List<DataBase> crossInformation = new ArrayList<>();

        for (int i = 0; i < list.get(0).size(); i++) {
            for (int j = 0; j < list.get(1).size(); j++) {
                if(list.get(0).get(i) instanceof MadaReport && list.get(1).get(j) instanceof LabTest)
                {
                    String id1 = ((MadaReport) list.get(0).get(i)).getIdNum();
                    String id2 = ((LabTest) list.get(1).get(j)).getIdNum();
                    if(id1.equals(id2) && ((LabTest) list.get(1).get(j)).getResultTestCorona().equals("1")){
                        crossInformation.add(new PatientsLivingDetails(((LabTest) list.get(1).get(j)).getIdNum(), ((LabTest) list.get(1).get(j)).getIdNum(),
                                ((LabTest) list.get(1).get(j)).getFirstName(), ((LabTest) list.get(1).get(j)).getLastName(),
                                ((MadaReport) list.get(0).get(i)).getCity(), ((MadaReport) list.get(0).get(i)).getStreet(),
                                ((MadaReport) list.get(0).get(i)).getBuildingNumber(), ((MadaReport) list.get(0).get(i)).getBarcode(), ((LabTest) list.get(1).get(j)).getBirthDate(),
                                ((LabTest) list.get(1).get(j)).getLabCode(), ((MadaReport) list.get(0).get(i)).getResultDate(),
                                ((MadaReport) list.get(0).get(i)).getTakeDate(), ((LabTest) list.get(1).get(j)).getStickerNumber(),
                                ((LabTest) list.get(1).get(j)).getResultTestCorona(), ((LabTest) list.get(1).get(j)).getVariant(), (((LabTest) list.get(1).get(j)).getTestType())));
                    }
                }
            }
        }

        return crossInformation;
    }
}
