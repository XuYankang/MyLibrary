package concurrency;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by jacob on 14/11/10.
 */
public class ConsumerAndProducer {

    public static void main(String[] args) {
        Queue<Date> queue = new LinkedList<Date>();
        final ProducerA producerA = new ProducerA(queue);

        Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                producerA.put();
            }
        });


        Thread threadb = new Thread(new Runnable() {
            @Override
            public void run() {
                producerA.get();
            }
        });

        Thread threadc = new Thread(new Runnable() {
            @Override
            public void run() {
                producerA.get();
            }
        });

        threada.start();
        threadb.start();
        threadc.start();
    }

}


class ProducerA {

    Random random = new Random(47);

    Queue<Date> queue;
    int MAX = 5;

    ProducerA(Queue<Date> queue) {
        this.queue = queue;
    }

    public void put() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (this) {
                while (queue.size() >= 5) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                queue.add(new Date());
                System.out.println("producer put new date into queue");
                notify();
            }
        }
    }

    public void get() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (this) {
                while (queue.size() <= 0) {
                    try {
                        System.out.println("consumer wait...");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("consumer consume " + queue.poll());
                notify();
            }
        }
    }


}



