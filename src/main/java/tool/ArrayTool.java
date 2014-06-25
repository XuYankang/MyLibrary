package tool;

/**
 * Created by Administrator on 2014/6/23.
 */
public class ArrayTool {

    public static char[][] StringArrayTo2DCharArray(String... array) {
        char[][] result = new char[array.length][array[0].length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i].toCharArray();
        }
        return result;
    }
}
