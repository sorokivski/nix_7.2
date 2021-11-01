package service;

import annotation.CsvPropertyKey;
import entity.SightsPlaces;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CsvMapper {

    CsvParser parser = new CsvParser();

    public List<String> showAllRowsWithData() {
        return getSightsFromCsv();
    }

    public List<String> getSightsFromCsv() {

        List<String[]> dataArrays = parser.ParseSightsCsv();
        List<String> stringArrays = new ArrayList<>();

        for (int i = 0; i < parser.numOfRows - 1; i++) {
            stringArrays.add(getPlace(dataArrays.get(i)).toString());
        }
        return stringArrays;
    }

    public SightsPlaces getPlace(String[] s) {
        String string = "";
        for (String st : s) string += st + "\n";
        SightsPlaces place;
        try {
            Class<?> someClass = Class.forName(SightsPlaces.class.getName());
            place = (SightsPlaces) someClass.getDeclaredConstructor().newInstance();
            return setFieldsByType(place, string);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException("ERROR of creating class with values from file " + e);
        }

    }

    public SightsPlaces setFieldsByType(SightsPlaces place, String placeString) {

        Properties property = getStringAsProperty(placeString);
        Class<SightsPlaces> placeClass = SightsPlaces.class;
        Field[] fields = placeClass.getFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(CsvPropertyKey.class)) {
                String key = field.getAnnotation(CsvPropertyKey.class).value();
                try {
                    field.set(place, setTypeOfField(property.getProperty(key), field));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        return place;
    }

    private Properties getStringAsProperty(String placeString) {
        Properties property = new Properties();
        try (
                StringReader reader = new StringReader(placeString)
        ) {

            property.load(reader);
        } catch (IOException | NullPointerException e) {
            System.out.println("error: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return property;
    }


    private Object setTypeOfField(String propertyString, Field field) {
        if (field.getType().equals(int.class)
                || field.getType().equals(Integer.class))
            return Integer.parseInt(propertyString);
        else
            return propertyString;
    }

}
