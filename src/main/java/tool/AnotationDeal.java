package tool;

import java.lang.reflect.Field;

/**
 * Created by jacob on 14-8-21.
 */
public class AnotationDeal {

    public static void main(String[] args) throws NoSuchFieldException {
        Test test = new Test();
        Field[] fields = test.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Field ooo = test.getClass().getDeclaredField("ooo");
        AnotationO annotation = ooo.getAnnotation(AnotationO.class);
        System.out.println(annotation.id());
    }

}
