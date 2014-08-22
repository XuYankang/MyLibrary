package tool;

import java.io.Serializable;

/**
 * Created by jacob on 14-8-14.
 */

public class Test implements Serializable {
    public static void main(String[] args) {
        System.out.println("汉字");

    }

    @AnotationO(id = 3)
    int ooo;

    public static void serializeStaticState() {

    }


}
