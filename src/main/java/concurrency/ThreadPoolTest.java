package concurrency;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2014/7/17.
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        ArrayList<Future<String>> result = new ArrayList<Future<String>>();

        for (int i = 0; i < 4; i++) {
            Future<String> future = executorService.submit(new SampleThread("thread" + i));
            result.add(future);
        }

        for (int i = 0 ;i < result.size(); i++) {
            System.out.println(result.get(i).get());
        }

        executorService.shutdown();
        System.out.println("end");

    }
}
