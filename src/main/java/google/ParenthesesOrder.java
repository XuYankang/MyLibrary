package google;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jacob on 14-9-14.
 */
public class ParenthesesOrder {


    public static void main(String[] args) {


        String dir = "/Users/jacob/Downloads/";
        String inFile = dir + "1.in";
        String outFile = inFile.substring(0, inFile.lastIndexOf(".")) + ".out";
        ArrayList<String> result = new ArrayList<String>();
        try {
            process(inFile, result);
            FileUtils.writeLines(new File(outFile), result);
            System.out.println("finished");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void process(String inFile, ArrayList<String> output) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(inFile));
        while (scanner.hasNext()) {
            int size = scanner.nextInt();
            scanner.nextLine();
            for (int i = 1; i <= size; i++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                System.out.println(String.format("n=%d,k=%d", n, k));
                int count = 0;
                int[] array = new int[n * 2];
                for (int j = n * 2 - 1; j > n; j--) {
                    array[j] = 1;
                }




            }
        }

    }


    public static int[] findNext(int[] array) {
        int overflow = 1;
        for (int i = array.length - 1; i >= 0; i--) {

            if (i == 1 && overflow == 1) {
                array[i] = 0;
                overflow = 1;
            }
            if (i == 0 && overflow == 1) {
                overflow = 0;
                array[i] = 1;
            }
        }
        return array;

    }

    private static boolean valid(int[] s) {

        int count = 0;
        for (int c : s) {
            if (c == '0') {
                count++;
            }
            if (c == '1') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0 ? true : false;

    }

    private static void discard(int start, ArrayList<Integer> cards) {
        cards.remove(start);
        cards.remove(start);
        cards.remove(start);
    }

    public static int findPossibleDiscrad(ArrayList<Integer> in, int k) {

        if (in.size() < 3) {
            return in.size();
        }

        int min = in.size();
        for (int i = 0; i < in.size() - 2; i++) {
            if (in.get(i + 1) - in.get(i) == k && in.get(i + 2) - in.get(i + 1) == k) {

                ArrayList<Integer> cards = new ArrayList<Integer>(in);
                discard(i, cards);
                int possibleDiscrad = findPossibleDiscrad(cards, k);
                min = min > possibleDiscrad ? possibleDiscrad : min;
            }
        }


        return min;
    }


    private static <T> void swap(T[] array, int i, int j) {
        if (i == j) {
            return;
        }
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
