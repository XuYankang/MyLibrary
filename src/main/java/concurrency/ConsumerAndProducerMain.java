package concurrency;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Administrator on 2014/6/18.
 */
public class ConsumerAndProducerMain {
    public static void main(String[] args) {
        BlockingQueue<Good> blockingQueue = new LinkedBlockingDeque<Good>(5);

        String[] attenders = {"p1", "p2", "c1", "c2", "c3"};

        ArrayList<Thread> allThreads = new ArrayList<Thread>();

        for (String s : attenders) {
            if (s.startsWith("p")) {
                allThreads.add(new Thread(new Producer(s, blockingQueue)));
            } else {
                allThreads.add(new Thread(new Consumer(s, blockingQueue)));
            }
        }

        for (Thread thread : allThreads) {
            thread.start();
        }

    }
}
