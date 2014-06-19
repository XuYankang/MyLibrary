package tool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jacob on 2014/6/18.
 */
public class TimeTool {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String getCurrentTime() {
        return sdf.format(new Date());
    }
}
