package other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Administrator on 2014/6/10.
 */
public class BlockingQueue<T> {
    private Queue<T> queue = new LinkedList<T>();
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(T t, String name) throws InterruptedException {
        while (queue.size() >= capacity) {
            System.out.println(name + " put " + t + " wait. " + queue);
            wait();
        }
        queue.add(t);
        System.out.println(name + " put " + t);
        notify();
    }

    public synchronized T get(String name) throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println(name + " get wait." + queue);
            wait();
        }
        T item = queue.remove();
        System.out.println(name + " get " + queue);
        queue.clear();
        notifyAll();
        return item;
    }

    @Override
    public synchronized String toString() {
        return "BlockingQueue{" +
                "queue=" + queue +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue<Integer> queue = new BlockingQueue<Integer>(10);

        final Random random = new Random();

        final long startTime = System.currentTimeMillis();

        PutThread p1 = new PutThread("p1", queue, startTime);
        PutThread p2 = new PutThread("p2", queue, startTime);
        PutThread p3 = new PutThread("p3", queue, startTime);
        PutThread p4 = new PutThread("p4", queue, startTime);
        GetThread g1 = new GetThread("g1", queue, startTime);
        //GetThread g2 = new GetThread("g2", queue, startTime);
        p1.start();
        p2.start();
        g1.start();
        p3.start();
        p4.start();
        //g2.start();
    }
}

class PutThread extends Thread {

    Random random = new Random();
    String name;
    BlockingQueue queue;

    long startTime;

    PutThread(String name, BlockingQueue queue, long startTime) {
        this.name = name;
        this.queue = queue;
        this.startTime = startTime;
    }

    @Override
    public void run() {
        while (true) {
            int x = random.nextInt(100);
            //System.out.println(System.currentTimeMillis() - startTime + "#" + name + " put " + x + " | queue:" + queue);
            try {
                queue.put(x, name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(random.nextInt(1000) + 200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class GetThread extends Thread {
    Random random = new Random();
    String name;
    BlockingQueue queue;

    long startTime;

    GetThread(String name, BlockingQueue queue, long startTime) {
        this.name = name;
        this.queue = queue;
        this.startTime = startTime;
    }

    @Override
    public void run() {
        while (true) {
            Object x = 0;
            try {
                x = queue.get(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(System.currentTimeMillis() - startTime + "# get " + x + " | queue:" + queue);
            try {
                Thread.sleep(random.nextInt(500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

