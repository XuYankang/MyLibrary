package test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob on 14-9-22.
 */
public class ReflectTest {
    int a;
    double b;
    ArrayList<String> c;



    public static void main(String[] args) {
        ReflectTest reflectTest = new ReflectTest();
        extract(reflectTest);
    }

    private static void extract(Object reflectTest) {
        for (Field field : reflectTest.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getClass().getInterfaces()[0]);
            System.out.print(field.getName() + ":");

            try {
                System.out.println(field.get(reflectTest));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }
}
