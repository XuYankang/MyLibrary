package concurrency;

import java.util.Random;

/**
 * Created by Administrator on 2014/6/18.
 */
public class Good {

    public static Random random = new Random();

    public static int count = 0;

    String name;

    public Good(String name) {
        this.name = name;
    }

    public static Good generate() {
        return new Good("good" + count++);
    }


    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                '}';
    }
}
