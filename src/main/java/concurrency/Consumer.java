package concurrency;

import java.util.Random;

/**
 * Created by Administrator on 2014/6/18.
 */
public class Consumer implements Runnable {
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        Random random = new Random();
        String message = drop.get();
        while (message != "Done") {
            System.out.println("consumer received: " + message);
            message = drop.get();
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
