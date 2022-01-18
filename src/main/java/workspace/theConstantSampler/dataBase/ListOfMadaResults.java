package workspace.theConstantSampler.dataBase;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

public class ListOfMadaResults implements DataBaseFactory{

    List<DataBase> madaResults;

    @Override
    public void create() {
        madaResults = new ArrayList<>();
    }

    @Override
    public void add(String[] values) {
        String madaCode = values[0];
        String idNum = values[1];
        String idType = values[2];
        String firstName = values[3];
        String lastName = values[4];
        String city = values[5];
        String street = values[6];
        String buildingNumber = values[7];
        String barcode = values[8];
        String getDate = values[9];
        String takeDate = values[10];
        String resultDate = values[11];

        this.madaResults.add(new MadaReport(madaCode, idNum, idType, firstName, lastName,
                city, street, buildingNumber, barcode, getDate, takeDate, resultDate));
    }

    @Override
    public List<DataBase> get() {
        return this.madaResults;
    }
}
