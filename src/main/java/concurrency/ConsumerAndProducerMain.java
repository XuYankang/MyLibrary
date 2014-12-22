package concurrency;

/**
 * Created by Administrator on 2014/6/18.
 */
public class ConsumerAndProducerMain {
    public static void main(String[] args) {
        Drop drop = new Drop();
        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}
