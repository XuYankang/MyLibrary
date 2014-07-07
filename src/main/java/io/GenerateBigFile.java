package io;

import java.util.Random;

/**
 * Created by Administrator on 2014/6/30.
 */
public class GenerateBigFile {
    public static void main(String[] args) {
        Class<Random> tc = Random.class;

        System.out.println(tc);
        ClassLoader classloader = tc.getClassLoader();


    }
}
