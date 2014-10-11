package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jacob on 14-9-29.
 */
public class Join {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new LongTask(i));
        }
        System.out.println("start wait...");

        executorService.shutdown();


    }
}
