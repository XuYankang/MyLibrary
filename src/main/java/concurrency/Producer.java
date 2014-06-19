package concurrency;

import tool.ConsoleTool;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2014/6/18.
 */
public class Producer implements Runnable {

    String name;
    BlockingQueue<Good> blockingQueue;

    public Producer(String name, BlockingQueue<Good> blockingQueue) {
        this.name = name;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {

            //ConsoleTool.print(name, "start producing...");
            try {
                if (blockingQueue.size() == 5) {
                    ConsoleTool.print("queue is full...");
                }
                Good good = Good.generate();
                blockingQueue.put(good);
                Thread.sleep(1000);
                ConsoleTool.print("produced", good);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
