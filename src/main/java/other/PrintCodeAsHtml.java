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
        File dir = new File("/Users/jacob/dev/workspace/MyLibrary/src/main/java/leetcode/");
        StringBuilder stringBuilder = new StringBuilder();
        for (File file : dir.listFiles()) {
            if (file.getName().startsWith(".") || file.isDirectory() || !file.getName().endsWith("java")) {
                continue;
            }
            stringBuilder.append("<h1>" + file.getName() + "</h1><hr>");
            List<String> list = FileUtils.readLines(file, "UTF-8");
            for (String line : list) {

                line = line.replace("&","&amp;");
                line = line.replace(" ","&nbsp;");
                line = line.replace("\t","&bnsp;&bnsp;&bnsp;&bnsp;");
                line = line.replace("\"","&quot;");
                line = line.replace("<","&lt;");
                line = line.replace(">","&gt;");
                stringBuilder.append(line + "<br>");
            }
            stringBuilder.append("<hr>");
        }
        System.out.println(stringBuilder);
        FileUtils.writeStringToFile(new File("/Users/jacob/temp/leetcode.html"), stringBuilder.toString());
    }
}
