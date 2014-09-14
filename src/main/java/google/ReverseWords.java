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
public class ReverseWords {
    public static void main(String[] args) {


        String dir = "/Users/jacob/Downloads/";
        String inFile = dir + "B-large-practice.in";
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

    private static void process(String inFile, ArrayList<String> result) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(inFile));
        while (scanner.hasNext()) {
            int size = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < size; i++) {
                String t = String.format("Case #%d: %s",i,reverse(scanner.nextLine()));
            }
        }
    }




    public static String reverse(String s) {
        if (s == "" || s.length() == 0) {
            return "";
        }
        String[] split = s.split(" ");

        String result = "";
        for (int i = split.length - 1; i >= 0; i--) {
            result += split[i] + " ";
        }

        return result.length() == 0 ? "" : result.substring(0, result.length() - 1);
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
