package leetcode.error;

/**
 * Created by Jacob on 2014/5/6.
 */
public class IntegertoRomanError {

    public static void main(String[] args) {
        IntegertoRomanError solution = new IntegertoRomanError();
        System.out.println(solution.intToRoman(9));
    }


    public String intToRoman(int num) {
        int[] valueMap = {1, 5, 10, 50, 100, 500, 1000};
        char[] symbolMap = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        String[] oneToNine = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        int[] digitArray = new int[7];

        for (int i = 0; i < valueMap.length; i++) {
            int x = num / valueMap[6 - i];
            digitArray[i] = x;
            num -= (x * valueMap[6 - i]);
        }

        String result = "";
        for (int i = 0; i < digitArray.length - 1; i++) {
            if (digitArray[i] != 0) {
                if (digitArray[i] != 1) {
                    result += (oneToNine[digitArray[i] - 1] + symbolMap[6 - i]);
                } else {
                    result += (symbolMap[6 - i]);
                }
            }
        }
        if (digitArray[6] != 0) {
            result += oneToNine[digitArray[6]-1];
        }


        return result;

    }


}
