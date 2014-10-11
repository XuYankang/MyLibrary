package concurrency;

import java.util.Random;

/**
 * Created by jacob on 14-9-29.
 */
public class LongTask implements Runnable {

    static Random random = new Random(47);

    int id;

    public LongTask(int i) {
        this.id = i;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            int sleepTime = 200 + random.nextInt(200);
            try {
                Thread.sleep(sleepTime);
                System.out.println(id + ":sleep " + sleepTime + " ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
