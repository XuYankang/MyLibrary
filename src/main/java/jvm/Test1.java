package jvm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Administrator on 2014/4/30.
 */
public class Test1 {

    public void say() {
        System.out.println("hello, here");
    }

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        int a = 100;
//        int b = 200;
//        int c = 300;
//        int d = (a + b) * c;
//        System.out.println(d);
//
//        Test1 t = new Test1();
        URLClassLoader loader = new URLClassLoader(
                new URL[]{new URL("http://localhost:8080/jvm/MyLibrary.jar")});
        Class c = loader.loadClass("leetcode.AddBinary");
        Object instance = c.newInstance();
        Object[] array = new Object[0];
        Method m = c.getMethod("main", new Class[]{args.getClass()});

        m.setAccessible(true);
        m.invoke(null, new Object[]{args});

        Test test = new Test();

    }


}
