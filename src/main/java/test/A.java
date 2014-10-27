package test;

/**
 * Created by jacob on 14-10-18.
 */
public class A {
    static int total = 10;

    public void call() {
        int total = 5;
        System.out.println(this.total);

    }

    public static void main(String[] args) {
        A a = new A();
        a.call();
    }
}
