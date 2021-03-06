package postoffice.converter;

import postoffice.entity.Office;

import java.util.ArrayList;


public class OfficeConverter implements Convertor<Office> {

    @Override
    public ArrayList<Office> convertToEntity(ArrayList<ArrayList<String>> officeRegistrationList) {
        ArrayList<Office> offices = new ArrayList<>();
        for (ArrayList<String> commandList : officeRegistrationList) {
            Office office = new Office();
            office.setAddress(commandList.get(1));
            office.setDescription(commandList.get(2));
            offices.add(office);
        }
        return offices;
    }
}
