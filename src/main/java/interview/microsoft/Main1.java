package interview.microsoft;

import java.util.Scanner;

/**
 * Created by jacob on 14/10/19.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        while (num-- > 0) {
            int length = in.nextInt();
            in.nextLine();
            String line = in.nextLine();
            int count = 1;
            int continueSize = 1;
            int maxContinueSize = 1;
            for (int i = 1; i < line.length(); i++) {
                if (line.charAt(i) - line.charAt(i - 1) == 0) {
                    if (continueSize + 1 > maxContinueSize && count >= 3) {
                        count = 1;
                        continueSize = 1;
                        maxContinueSize = 1;
                    } else {
                        continueSize++;
                        if (maxContinueSize < continueSize) {
                            maxContinueSize = continueSize;
                        }
                    }
                    continue;
                }
                if (line.charAt(i) - line.charAt(i - 1) == 1) {
                    count++;
                    if (maxContinueSize != continueSize) {
                        count = -1;
                        break;
                    }
                    continueSize = 1;
                } else {
                    if (count < 3) {
                        break;
                    }
                }
            }
            if (count >= 3 && maxContinueSize == continueSize) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }


        }
    }


}
