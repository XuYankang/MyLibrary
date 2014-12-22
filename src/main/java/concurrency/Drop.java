package concurrency;

/**
 * Created by Administrator on 2014/6/18.
 */
public class Drop {

    String message;
    volatile boolean empty = false;


    public synchronized void set(String message) {

        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        empty = false;
        this.message = message;
        System.out.println("put " + message);
        notifyAll();

    }

    public synchronized String get() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notifyAll();
        System.out.println("take " + message);
        return message;
    }
}
