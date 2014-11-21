package algorithm;

/**
 * Created by jacob on 14/11/13.
 */
public class GCD {
    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.gcd(100, 10));
        System.out.println(gcd.gcd(32, 10));
        System.out.println(gcd.gcd(4, 10));
        System.out.println(gcd.gcd(32, 12));


    }

    public int gcd(int a, int b) {

        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int t = 100;
        while (t != 0) {
            t = a % b;
            a = b;
            b = t;
        }
        return a;
    }


}
