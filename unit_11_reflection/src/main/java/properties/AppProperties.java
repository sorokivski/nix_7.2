package properties;

import annotation.PropertyKey;
import entity.Purchase;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class AppProperties {

    public Purchase purchase = null;
    String propPath = "/app.properties";

    public Properties getProperty() {
        Properties property = new Properties();
        try (InputStream input = properties.AppProperties.class.getResourceAsStream(propPath)) {
            property.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return property;
    }

    public void setFieldsByType() {
        Properties property = getProperty();
        Class<Purchase> purchaseClass = Purchase.class;
        Field[] fields = purchaseClass.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(PropertyKey.class)) {
                String key = field.getAnnotation(PropertyKey.class).value();
                try {
                    field.set(purchase, setTypeOfField(property.getProperty(key), field));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private Object setTypeOfField(String propertyString, Field field) {

        if (field.getType().equals(Date.class)) {
            try {
                return new SimpleDateFormat("dd/MM/yyyy").parse(propertyString);
            } catch (ParseException e) {
                throw new RuntimeException("invalid format of data in file app.properties: ", e);
            }
        }
        if(field.getType().equals(boolean.class)) return Boolean.parseBoolean(propertyString);
        if (field.getType().equals(int.class)
                || field.getType().equals(Integer.class))
            return Integer.parseInt(propertyString);
        if (field.getType().equals(double.class)
                || field.getType().equals(Double.class))
            return Double.parseDouble(propertyString);
        if (field.getType().equals(float.class)
                || field.getType().equals(Float.class))
            return Float.parseFloat(propertyString);
        if (field.getType().equals(String.class))
            return propertyString;

        return null;
    }

    public Purchase getPurchase() {

        try {
            Class<?> someClass = Class.forName(Purchase.class.getName());
            purchase = (Purchase) someClass.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException | ClassNotFoundException e) {
           throw new RuntimeException("ERROR of creating class with values from file " + e);
        }
        setFieldsByType();

        return purchase;
    }
}
