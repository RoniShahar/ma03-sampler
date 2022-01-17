package workspace.theConstantSampler.dataBase;

public class MadaReport extends DataBase{

    protected String madaCode;
    protected String idNum;
    protected String idType;
    protected String firstName;
    protected String lastName;
    protected String city;
    protected String street;
    protected String buildingNumber;
    protected String barcode;
    protected String takeDate;
    protected String resultDate;

    public MadaReport(String madaCode, String idNum, String idType,
                      String firstName, String lastName, String city,
                      String street, String buildingNumber, String barcode,
                      String getDate, String takeDate, String resultDate) {
        this.madaCode = madaCode;
        this.idNum = idNum;
        this.idType = idType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.barcode = barcode;
        this.takeDate = takeDate;
        this.resultDate = resultDate;

    }

    public String getMadaCode() {
        return madaCode;
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

    public String getTakeDate() {
        return takeDate;
    }

    public String getResultDate() {
        return resultDate;
    }
}
