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
public class PasswordAttacker {

    public static final int modulo = 1000000007;

    public static void main(String[] args) {


        String dir = "/Users/jacob/Downloads/";
        String inFile = dir + "A-large.in";
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
                int m = scanner.nextInt();
                int n = scanner.nextInt();
                System.out.println(String.format("m=%d,n=%d", m, n));
                scanner.nextLine();
                long totalrange = totalRange(n);
                if (m == n) {
                    String t = String.format("Case #%d: %s", i, totalrange % modulo);
                    output.add(t);
                    System.out.println(t);
                    continue;
                }
                ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
                ArrayList<Integer> current = new ArrayList<Integer>();
                findPossible(result, current, m, n - m, 0);
                long resultNum = 0;


                for (ArrayList<Integer> integers : result) {
                    int[] everyNumCount = new int[m];
                    for (int j = 0; j < everyNumCount.length; j++) {
                        everyNumCount[j] = 1;

                    }
                    for (Integer integer : integers) {
                        everyNumCount[integer]++;
                    }

                    int divideAll = 1;

                    for (int i1 : everyNumCount) {
                        divideAll *= totalRange(i1);

                    }
                    resultNum += totalrange / divideAll;


                }

                String t = String.format("Case #%d: %s", i, resultNum % modulo);
                System.out.println(t);
                output.add(t);

            }
        }
    }

    public static void findPossible(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int m, int neededSize, int start) {

        if (current.size() == neededSize) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        for (int i = start; i < m; i++) {
            current.add(i);
            findPossible(result, current, m, neededSize, i);
            current.remove(current.size() - 1);
        }

    }


    public static long totalRange(int N) {
        if (N == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= N; i++) {
            result *= i;
        }
        return result;
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
