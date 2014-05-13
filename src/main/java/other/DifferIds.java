package other;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Jacob on 2014/4/22.
 */
public class DifferIds {

    static File before = new File("D:/result/before.txt");
    static File after = new File("d:/result/after.txt");
    static File dir = new File("d:/result");
    static File[] files;

    public static File findFile(int siteId, int stategy) {
        if (files == null) {
            files = dir.listFiles();
        }
        for (File f : files) {
            String name = f.getName();
            String[] parts = name.split("_");
            if (Integer.parseInt(parts[0]) == siteId && Integer.parseInt(parts[1]) == stategy) {
                return f;
            }
        }
        return null;
    }

    public static File findFile(String tail) {
        if (files == null) {
            files = dir.listFiles();
        }
        for (File f : files) {
            String name = f.getName();
            if (name.endsWith(tail + ".csv")) {
                return f;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {

        List<String> beforeLines = FileUtils.readLines(findFile("1398217828802"));
        HashSet<Integer> beforeSet = new HashSet<Integer>();
        for (String s : beforeLines) {
            beforeSet.add(Integer.parseInt(s.split(",")[0]));
        }
        List<String> afterLines = FileUtils.readLines(findFile("1398243357227"));
        HashSet<Integer> afterSet = new HashSet<Integer>();
        for (String s : afterLines) {
            afterSet.add(Integer.parseInt(s.split(",")[0]));
        }
        HashSet<Integer> afterClone = (HashSet<Integer>) afterSet.clone();
        afterSet.removeAll(beforeSet);
        beforeSet.removeAll(afterClone);
        System.out.println("after - before");
        System.out.println(afterSet);
        System.out.println("before - after");
        System.out.println(beforeSet);

    }

}
