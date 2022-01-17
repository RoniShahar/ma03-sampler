package workspace.theConstantSampler.dataBase;

import java.time.LocalDate;

public class TransformLabTest extends LabTest{
    protected LocalDate joinDate;
    protected int healthCareId;
    protected String healthCareName;

    public TransformLabTest(String idNum, String idType, String firstName, String lastName,
                            String resultDate, String birthDate, String labcode, String stickerNumber,
                            String resultTestCorona, String variant, String testType, LocalDate joinDate,
                            int healthCareId, String healthCareName) {
        super(idNum, idType, firstName, lastName, resultDate, birthDate, labcode, stickerNumber,
                resultTestCorona, variant, testType);
        this.joinDate = joinDate;
        this.healthCareId = healthCareId;
        this.healthCareName= healthCareName;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public int getHealthCareId() {
        return healthCareId;
    }

    public String getHealthCareName() {
        return healthCareName;
    }
}
