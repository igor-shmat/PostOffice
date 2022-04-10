package postoffice.converter;

import java.util.ArrayList;

public interface Convertor<Entity> {

    ArrayList<Entity> convertToEntity(ArrayList<ArrayList<String>> string);

}
