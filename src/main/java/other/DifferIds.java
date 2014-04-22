package other;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Jacob on 2014/4/22.
 */
public class DifferIds {

    static File before = new File("D:/before.txt");
    static File after = new File("d:/after.txt");

    public static void main(String[] args) throws IOException {

        List<String> beforeLines = FileUtils.readLines(before);
        HashSet<Integer> beforeSet = new HashSet<Integer>();
        for (String s : beforeLines) {
            beforeSet.add(Integer.parseInt(s.split("\t")[0]));
        }
        List<String> afterLines = FileUtils.readLines(after);
        HashSet<Integer> afterSet = new HashSet<Integer>();
        for (String s : afterLines) {
            afterSet.add(Integer.parseInt(s.split("\t")[0]));
        }
        System.out.println(beforeSet.size());
        System.out.println(afterSet.size());
        //afterSet.removeAll(beforeSet);
        beforeSet.removeAll(afterSet);
        System.out.println(beforeSet);

    }

}
