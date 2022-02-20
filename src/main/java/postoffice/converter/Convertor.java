package postoffice.converter;

import java.util.ArrayList;

public interface Convertor<Entity> {

    ArrayList<Entity> convert(ArrayList<ArrayList<String>> string);

}
