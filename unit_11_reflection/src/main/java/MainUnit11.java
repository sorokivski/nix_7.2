import entity.Purchase;
import properties.AppProperties;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainUnit11 {

    public static void main(String[] args) {
        Purchase somePurchase = new AppProperties().getPurchase();
        try {
            Method getMethod = somePurchase.getClass().getMethod("toString");
            System.out.println(getMethod.invoke(somePurchase).toString());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
