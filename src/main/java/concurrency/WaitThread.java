package concurrency;

import other.BlockingQueue;

/**
 * Created by jacob on 14/11/6.
 */
public class WaitThread implements Runnable {
    StringBuilder sb;
    int id;

    public WaitThread(StringBuilder sb, int id) {
        this.sb = sb;
        this.id = id;
    }

    @Override
    public void run() {
        synchronized (sb) {
            while (sb.length() > 0 && sb.charAt(0) != '!') {
                System.out.println(id + " start waiting:" + System.currentTimeMillis());
                try {
                    sb.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(id + " still waiting..." + System.currentTimeMillis());
            }
            System.out.println(id + " end waiting:" + System.currentTimeMillis());
        }

    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(".");
        Thread notify = new Thread(new NotifyThread(sb));
        Thread wait1 = new Thread(new WaitThread(sb, 1));
        Thread wait2 = new Thread(new WaitThread(sb, 2));
        notify.start();
        wait1.start();
        wait2.start();
    }
}
