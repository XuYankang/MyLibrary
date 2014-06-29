package concurrency;

import java.util.Random;

/**
 * Created by Administrator on 2014/6/18.
 */
public class Producer implements Runnable {

    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }


    @Override
    public void run() {
        String messages[] = {"a", "b", "c", "d"};
        Random random = new Random();
        for (String s : messages) {
            drop.set(s);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        drop.set("Done");
    }
}
