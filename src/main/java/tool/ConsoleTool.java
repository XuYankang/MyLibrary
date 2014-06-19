package tool;

/**
 * Created by Administrator on 2014/6/18.
 */
public class ConsoleTool {

    public static void print(Object... args) {
        StringBuilder sb = new StringBuilder(TimeTool.getCurrentTime() + "  ");
        for (Object arg : args) {
            sb.append(arg + " ");

        }
        System.out.println(sb.toString());

    }

}
