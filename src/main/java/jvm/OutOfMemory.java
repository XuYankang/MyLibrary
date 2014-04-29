package jvm;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/4/28.
 */
public class OutOfMemory {

    static class OOMObject {
    }

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        System.out.println(stackLength);
        stackLeak();
    }

    public static void main(String[] args) {
        /*ArrayList<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }*/
        /*OutOfMemory oom = new OutOfMemory();
        try {
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println(oom.stackLength);
            // e.printStackTrace();
        }*/
        ArrayList<String> list = new ArrayList<String>();
        int value = 0;
        while (true) {
            if (value % 10000 ==0) {
                System.out.println(value);
            }
            value++;
            list.add(String.valueOf(value).intern());
        }
    }
}
