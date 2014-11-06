package concurrency;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Jacob on 2014/6/18.
 */
public class Test {

    static Random random = new Random();
    static int count = 1;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        int size = 1000000;
        final CountDownLatch countDownLatch = new CountDownLatch(size);

        final ArrayList<Double> list = new ArrayList<Double>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextDouble());
        }

        long start = System.currentTimeMillis();

        class Cal implements Runnable {
            ArrayList<Double> list;
            int i;

            Cal(ArrayList<Double> list, int i) {
                this.list = list;
                this.i = i;
            }

            @Override
            public void run() {
                double v = list.get(i) * list.get(i);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            executorService.submit(new Cal(list, i));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        executorService.shutdown();
    }
}
