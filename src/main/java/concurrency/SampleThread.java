package concurrency;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2014/7/17.
 */
public class SampleThread implements Callable<String> {

    String name;

    public SampleThread(String name) {
        this.name = name;
    }

    Random random = new Random();


    private void sleepRandom() {
        try {
            Thread.sleep((random.nextInt(2000)) + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep " + name);
    }

    @Override
    public String call() throws Exception {
        sleepRandom();
        System.out.println(name);
        sleepRandom();
        System.out.println("end " + name);
        return name + " finished";
    }
}
