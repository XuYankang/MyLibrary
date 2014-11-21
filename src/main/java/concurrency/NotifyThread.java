package concurrency;

/**
 * Created by jacob on 14/11/6.
 */
public class NotifyThread implements Runnable {

    StringBuilder sb;

    public NotifyThread(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (sb) {
            sb.setCharAt(0, '!');
            sb.notifyAll();
        }
    }
}
