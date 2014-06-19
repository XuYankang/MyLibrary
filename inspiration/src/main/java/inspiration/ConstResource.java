package inspiration;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2014/6/19.
 */
public class ConstResource {

    public static final String hudongPrefix = "http://www.baike.com/wiki/";

    public static final File savedFile = new File("d:/hudong/hudong.txt");

    public static final String savedDir = "d:/hudong/";

    static {
        if (!new File(savedDir).exists()) {
            new File(savedDir).mkdirs();
        }
    }

    public static final Pattern pattern = Pattern.compile("/wiki/(.*?)\\?");

    public static final File savedFile(String item) {
        return new File(savedDir + "data/" + item + ".txt");
    }

    public static final ConcurrentHashMap<String, String> urlMap = new ConcurrentHashMap<String, String>();


    public static final File downloaded = new File(savedDir + "downloaded.txt");
    public static final File waiting = new File(savedDir + "waiting.txt");


    public static int maxThread = 10;

}
