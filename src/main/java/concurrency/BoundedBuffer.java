package concurrency;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by jacob on 14/11/12.
 */
public class BoundedBuffer<V> {

    Object[] list;
    int size;
    int putIndex;
    int getIndex;
    int currentSize;

    public BoundedBuffer(int size) {
        list = new Object[size];
        this.size = size;
        putIndex = 0;
        getIndex = 0;
        currentSize = 0;
    }

    public synchronized V get() {
        while (currentSize == 0) {
            try {
                wait();
                System.out.println("waiting for empty buffer");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object obj = list[getIndex];
        if (++getIndex == size) {
            getIndex = 0;
        }
        currentSize--;
        System.out.println("got item " + obj);
        notifyAll();
        return (V) obj;
    }

    public synchronized void put(V v) {
        while (currentSize == size) {
            try {
                wait();
                System.out.println("\twaiting for full buffer.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list[putIndex] = v;
        if (++putIndex == size) {
            putIndex = 0;
        }
        currentSize++;
        System.out.println("\tput item " + v);
        notifyAll();
    }

    public static void main(String[] args) {
        final BoundedBuffer<Integer> buffer = new BoundedBuffer<Integer>(5);
        final Random random = new Random();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int t1 = 1000;
                while (true && t1 < 2000) {
                    buffer.put(t1++);
                    try {
                        Thread.sleep(random.nextInt(20));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int t2 = 2000;
                while (true && t2 < 3000) {
                    buffer.put(t2++);
                    try {
                        Thread.sleep(random.nextInt(20));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    buffer.get();
                    try {
                        Thread.sleep(random.nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();


    }

}
