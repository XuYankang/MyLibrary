package algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Jacob on 2014/4/23.
 */
public class FindTwoMaxNum {

    public static void main(String[] args) {
        int[] array = new int[100];
        Random rand = new Random(47);
        for (int i = 0; i < 100; i++) {
            array[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        findMaxTwo(array);

    }

    private static void findMaxTwo(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                secondMax = max;
                max = array[i];
            } else if (max > array[i] && secondMax < array[i]) {
                secondMax = array[i];
            }

        }
        System.out.println(max);
        System.out.println(secondMax);
    }

}
