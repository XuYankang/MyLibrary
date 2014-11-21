package concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jacob on 14/11/10.
 */
public class Conditions {
    class NumberWrapper {
        int value;
    }

    Random random = new Random(47);

    Queue<Integer> queue = new LinkedList<Integer>();
    int max = 5;


    final Lock lock = new ReentrantLock();
    Condition full;
    Condition empty;

    public Conditions() {
        full = lock.newCondition();
        empty = lock.newCondition();
    }

    public void put(Integer i) {
        try {
            lock.lockInterruptibly();
            while (queue.size() >= max) {
                System.out.println("full...");
                full.await();
            }
            queue.add(i);
            //Thread.sleep(1000);
            System.out.println("add " + i);
            empty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }

    }

    public void get() {
        try {
            lock.lockInterruptibly();
            while (queue.size() == 0) {
                System.out.println("empty...");
                empty.await();
            }
            int i = queue.remove();
            //Thread.sleep(1000);
            System.out.println("remove " + i);
            full.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }


    public static void main(String[] args) {
        final Conditions conditions = new Conditions();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    conditions.put(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 10; i < 20; i++) {
                    conditions.put(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (int i = 0; i < 10; i++) {
                        conditions.get();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (int i = 0; i < 10; i++) {
                        conditions.get();
                    }
                }
            }
        }).start();
    }
}
