package concurrency;

import tool.ConsoleTool;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2014/6/18.
 */
public class Consumer implements Runnable {
    String name;
    BlockingQueue<Good> blockingQueue;


    public Consumer(String name, BlockingQueue<Good> blockingQueue) {
        this.name = name;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            //ConsoleTool.print(name, "start consume...");
            try {
                if (blockingQueue.isEmpty()) {
                    ConsoleTool.print("queue is empty..");
                }
                Good good = blockingQueue.take();
                Thread.sleep(2000);
                ConsoleTool.print("consumed", good);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
