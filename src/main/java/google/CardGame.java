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
public class CardGame {


    public static void main(String[] args) {


        String dir = "/Users/jacob/Downloads/";
        String inFile = dir + "C-small-attempt0.in";
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
                scanner.nextLine();
                String line = scanner.nextLine();
                System.out.println(line);
                String[] split = line.split(" ");
                ArrayList<Integer> cards = new ArrayList<Integer>();
                for (int j = 0; j < split.length; j++) {
                    cards.add(Integer.valueOf(split[j]));
                }
                int possibleDiscrad = findPossibleDiscrad(cards, k);
                System.out.println(possibleDiscrad);
                String t = String.format("Case #%d: %s", i, possibleDiscrad);
                output.add(t);

            }
        }
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
