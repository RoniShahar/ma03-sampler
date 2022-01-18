package workspace.theConstantSampler.processing;

import workspace.theConstantSampler.dataBase.DataBase;
import workspace.theConstantSampler.dataBase.LabTest;
import workspace.theConstantSampler.dataBase.MadaReport;
import workspace.theConstantSampler.dataBase.PatientsLivingDetails;

import java.util.ArrayList;
import java.util.List;

public class ProcessingOfPatientsLivingDetails implements ProcessingFactory{

    @Override
    public List<DataBase> Transfrom(List<List<DataBase>> list) {
       List<DataBase> crossInformation = new ArrayList<>();

        for (int i = 0; i < list.get(0).size(); i++) {
            for (int j = 0; j < list.get(1).size(); j++) {
                if(list.get(0) instanceof MadaReport && list.get(1) instanceof LabTest)
                {
                    if(((MadaReport) list.get(0).get(i)).getIdNum() == ((LabTest) list.get(1).get(j)).getIdNum()){
                        crossInformation.get(new PatientsLivingDetails(((LabTest) list.get(1).get(j)).getIdNum(), ((LabTest) list.get(1).get(j)).getTestType(),
                                ((LabTest) list.get(1).get(j)).getFirstName(), ((LabTest) list.get(1).get(j)).getFirstName(),
                                ((MadaReport) list.get(0).get(j)).getCity(), ((MadaReport) list.get(0).get(j)).getStreet(),
                                ((MadaReport) list.get(0).get(j)).getBuildingNumber(), ((MadaReport) list.get(0).get(j)).getBarcode(), ((LabTest) list.get(1).get(j)).getBirthDate(),
                                ((MadaReport) list.get(0).get(j)).getBarcode(), ((MadaReport) list.get(0).get(j)).getResultDate(),
                                ((MadaReport) list.get(0).get(j)).getTakeDate(), ((LabTest) list.get(1).get(j)).getStickerNumber(),
                                ((LabTest) list.get(1).get(j)).getResultTestCorona(), (((LabTest) list.get(1).get(j)).getVariant(), (((LabTest) list.get(1).get(j)).getTestType())));
                    }
                }
            }
        }

        return crossInformation;
    }
}
