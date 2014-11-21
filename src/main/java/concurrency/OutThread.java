package concurrency;

/**
 * Created by jacob on 14/11/6.
 */
public class OutThread implements Runnable {
    private int num;
    private Object lock;

    public OutThread(int num, Object lock) {
        super();
        this.num = num;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (lock) {
                    lock.notifyAll();
                    lock.wait();
                    System.out.println(num);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Thread thread1 = new Thread(new OutThread(1, lock));
        Thread thread2 = new Thread(new OutThread(2, lock));

        thread1.start();
        thread2.start();
    }
}
