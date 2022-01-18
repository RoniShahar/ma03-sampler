package workspace.theConstantSampler.dataBase;

public class PatientsLivingDetails extends DataBase{
    protected String idNum;
    protected String idType;
    protected String firstName;
    protected String lastName;
    protected String city;
    protected String street;
    protected String buildingNumber;
    protected String barcode;
    protected String birthDate;
    protected String labCode;
    protected String resultDate;
    protected String takeDate;
    protected String stickerNumber;
    protected String resultTestCorona;
    protected String variant;
    protected String testType;

    public PatientsLivingDetails(String idNum, String idType, String firstName, String lastName, String city, String street,
                                 String buildingNumber, String barcode, String birthDate, String labCode, String resultDate,
                                 String takeDate, String stickerNumber, String resultTestCorona, String variant, String testType) {
        this.idNum = idNum;
        this.idType = idType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.barcode = barcode;
        this.birthDate = birthDate;
        this.labCode = labCode;
        this.resultDate = resultDate;
        this.takeDate = takeDate;
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

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getLabCode() {
        return labCode;
    }

    public String getResultDate() {
        return resultDate;
    }

    public String getTakeDate() {
        return takeDate;
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
