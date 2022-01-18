package workspace.theConstantSampler.dataBase;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "labTest")
public class LabTest extends DataBase{

    protected String idNum;
    protected String idType;
    protected String firstName;
    protected String lastName;
    protected String resultDate;
    protected String birthDate;
    protected String labCode;
    protected String stickerNumber;
    protected String resultTestCorona;
    protected String variant;
    protected String testType;

    public LabTest(String idNum, String idType, String firstName, String lastName, String resultDate,
                   String birthDate, String labCode, String stickerNumber, String resultTestCorona,
                   String variant, String testType) {
        this.idNum = idNum;
        this.idType = idType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.resultDate = resultDate;
        this.birthDate = birthDate;
        this.labCode = labCode;
        this.stickerNumber = stickerNumber;
        this.resultTestCorona = resultTestCorona;
        this.variant = variant;
        this.testType = testType;
    }

    public String getIdNum() {
        return idNum;
    }

    public String getIdType() {
        return idType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getResultDate() {
        return resultDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getLabCode() {
        return labCode;
    }

    public String getStickerNumber() {
        return stickerNumber;
    }

    public String getResultTestCorona() {
        return resultTestCorona;
    }

    public String getVariant() {
        return variant;
    }

    public String getTestType() {
        return testType;
    }
}
