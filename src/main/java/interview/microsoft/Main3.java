package interview.microsoft;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jacob on 14/10/19.
 */
public class Main3 {
    public static void main(String[] args) {
        //abcdefghijklmn
//        ababceghjklmn
        Scanner in = new Scanner(System.in);
        String strA = in.nextLine();
        String strB = in.nextLine();

        System.out.println(1);


        ArrayList<String> sames = new ArrayList<String>();

        int j = 0;
        String same = "";
        for (int i = 0; i < strA.length(); i++) {
            if (strA.charAt(i) == strB.charAt(j)) {
                same += strA.charAt(i);
                j++;
            } else {
                j = 0;

            }
        }


    }


}
