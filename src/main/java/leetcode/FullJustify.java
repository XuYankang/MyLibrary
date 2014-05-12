package leetcode;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/5/6.
 */
public class FullJustify {

    public static void main(String[] args) {
        FullJustify solution = new FullJustify();
        String[] in = {"Listen", "to", "many,", "speak", "to   a", "few.  "};

        System.out.println(solution.fullJustify(in, 6));
    }

    /**
     * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
     * <p/>
     * You should pack your words in a greedy approach;
     * that is, pack as many words as you can in each line.
     * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
     * <p/>
     * Extra spaces between words should be distributed as evenly as possible.
     * If the number of spaces on a line do not divide evenly between words,
     * the empty slots on the left will be assigned more spaces than the slots on the right.
     * <p/>
     * For the last line of text, it should be left justified and no extra space is inserted between words.
     * <p/>
     * For example,
     * words: ["This", "is", "an", "example", "of", "text", "justification."]
     * L: 16.
     * <p/>
     * Return the formatted lines as:
     * [
     * "This    is    an",
     * "example  of text",
     * "justification.  "
     * ]
     * Note: Each word is guaranteed not to exceed L in length.
     *
     * @param words
     * @param L
     * @return
     */
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        int curL = 0;
        ArrayList<String> curWords = new ArrayList<String>();
        for (String s : words) {
            if (curL - 1 <= L && curL + s.length() > L) {
                int wordsLength = 0;
                for (String cw : curWords) {
                    wordsLength += cw.length();
                }

                int spaceLength = L - wordsLength;
                int baseSpaceWidth = 0;

                if (curWords.size() == 1) {
                    baseSpaceWidth = spaceLength;
                } else {
                    baseSpaceWidth = spaceLength % (curWords.size() - 1) == 0 ?
                            spaceLength / (curWords.size() - 1) : (spaceLength / (curWords.size() - 1)) + 1;
                }
                String baseSpace = "";

                for (int i = 0; i < baseSpaceWidth; i++) {
                    baseSpace += " ";
                }
                String otherSapce = "";

                String outLine = curWords.get(0);
                for (int i = 1; i < curWords.size(); i++) {
                    if (spaceLength - baseSpaceWidth >= 0 && curWords.size() != 1) {
                        outLine += (baseSpace + curWords.get(i));
                        spaceLength -= baseSpaceWidth;
                    } else {
                        int otherSapceWidth = spaceLength;
                        for (int j = 0; j < otherSapceWidth; j++) {
                            otherSapce += " ";
                        }
                        outLine += (otherSapce + curWords.get(i));
                        spaceLength -= 1;
                    }
                }
                result.add(outLine.length() > L ? outLine.substring(0, L) : outLine);
                curL = 0;
                curWords.clear();
            }
            curL += s.length() + 1;
            curWords.add(s);

        }

        if (!curWords.isEmpty()) {
            String outLine = "";
            for (String w : curWords) {
                outLine += w;
                if (outLine.length() <= L) {
                    outLine += " ";
                }
            }
            for (int i = L - outLine.length(); i > 0; i--) {
                outLine += " ";
            }
            result.add(outLine.length() > L ? outLine.substring(0, L) : outLine);
        }

        return result;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
