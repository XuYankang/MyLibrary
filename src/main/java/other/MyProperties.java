package other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2014/6/25.
 */
public class MyProperties {
    public static void main(String[] args) {
        match("的", "你好的天气的世界");
    }

    public static void match(String patternString, String text) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        System.out.println("pattern:" + patternString);
        System.out.println("text:" + text);
        StringBuffer sb = new StringBuffer();

        String result = matcher.replaceAll("-");
        System.out.println(result);

    }


    public int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }


}
