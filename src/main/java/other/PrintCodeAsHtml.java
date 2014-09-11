package other;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by jacob on 14-9-11.
 */
public class PrintCodeAsHtml {
    public static void main(String[] args) throws IOException {
        ///Users/jacob/dev/workspace/MyLibrary/src/main/java/
        File dir = new File("/Users/jacob/dev/workspace/MyLibrary/src/main/java/");
        StringBuilder stringBuilder = new StringBuilder();
        for (File file : dir.listFiles()) {
            List<String> list = FileUtils.readLines(file);
            
        }
    }
}
