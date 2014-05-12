package concurrency;

/**
 * Created by Administrator on 2014/5/6.
 */
public class UnSafe implements Runnable {

    private static int x = 1;

    public int increseOne() {
        x++;
        System.out.println(x);
        return x;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new UnSafe());
            thread.run();
            //Thread.currentThread().sleep(100);
        }
    }

    @Override
    public void run() {
        increseOne();
    }
}
