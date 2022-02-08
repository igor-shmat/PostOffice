package postoffice.converter;

import postoffice.entity.Office;

import java.util.ArrayList;

public class FileToOfficeConverter {
    public Office convert(ArrayList<String> commandsList) {
        Office office = new Office();
        office.setDescription(commandsList.get(1));
        return office;
    }
}
