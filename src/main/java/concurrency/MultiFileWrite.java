package concurrency;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jacob on 14/12/20.
 */
public class MultiFileWrite {
    public static void main(String[] args) {

        String namesString = "A B C";
        String[] names = namesString.split(" ");
        ArrayList<File> fileList = new ArrayList<File>();
        ArrayList<ReentrantLock> locks = new ArrayList<ReentrantLock>();
        for (int i = 0; i < names.length; i++) {
            fileList.add(new File("/Users/jacob/temp/file" + names[i]));
            locks.add(new ReentrantLock(false));
        }

        for (int i = 0; i < names.length; i++) {
            new Thread(new FileWriter(names[i], fileList, locks)).start();
        }

    }
}


class FileWriter implements Runnable {

    String[] lockNames = {"a", "b", "c"};
    static Random random = new Random(42);
    ArrayList<File> fileList = null;
    ArrayList<ReentrantLock> locks = null;
    String threadName = "";

    public FileWriter(String threadName, ArrayList<File> fileList, ArrayList<ReentrantLock> locks) {
        this.threadName = threadName;
        this.fileList = fileList;
        this.locks = locks;
    }

    @Override
    public void run() {
        System.out.println("start thread " + threadName);
        int count = 10;
        while (true) {
            for (int i = 0; i < locks.size(); i++) {
                ReentrantLock reentrantLock = locks.get(i);
                File file = fileList.get(i);
                if (reentrantLock.tryLock()) {
                    reentrantLock.lock();
                    System.out.println(String.format("%s get lock %s", threadName, lockNames[i]));
                    System.out.println(String.format("Thread %s is writing into file %s", threadName, file.getName()));
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    reentrantLock.unlock();
                    System.out.println(String.format("%s unlock %s", threadName, lockNames[i]));
                } else {
                    System.out.println(String.format("%s skip file %s because of locking.", threadName, file.getName()));
                }
            }
        }
        //   System.out.println("end thread " + threadName);


    }
}
