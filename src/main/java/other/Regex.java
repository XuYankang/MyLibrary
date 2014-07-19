package other;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2014/6/26.
 */
public class Regex {
    public static void main(String[] args) {
        String text = " <div id=\"bd\" class=\"cf\" style=\"position: static;\">\n" +
                "            <noscript data-multiact-params=\"{&quot;uri&quot;:&quot;\\/index\\/tips\\/deal\\/default&quot;,&quot;commontips&quot;:true,&quot;page&quot;:&quot;deal&quot;,&quot;deal&quot;:25373781}\" id=\"J-async-tips\" data-parent=\"#bd\"></noscript><div class=\"bread-nav\"><a gaevent=\"crumb/index\" href=\"http://sh.meituan.com\" data-mttcode=\"Abreadcrumb.B1\">上海团购</a><span>»</span><a gaevent=\"crumb/category/1\" href=\"http://sh.meituan.com/category/meishi\" data-mttcode=\"Abreadcrumb.B2\">美食团购</a><span>»</span><a gaevent=\"crumb/category/2\" href=\"http://sh.meituan.com/category/taiwancai\" data-mttcode=\"Abreadcrumb.B3\">台湾菜/客家菜</a><span>»</span><a gaevent=\"crumb/area/1\" href=\"http://sh.meituan.com/category/taiwancai/pudongxinqu\" data-mttcode=\"Abreadcrumb.B4\">浦东新区</a><span>»</span><a gaevent=\"crumb/area/2\" href=\"http://sh.meituan.com/category/taiwancai/babaiban\" data-mttcode=\"Abreadcrumb.B5\">八佰伴</a><span>»</span>小间堂</div>";

        Pattern pattern = Pattern.compile("<a .*?crumb/category/\\d.*?>(.*?)</a>");
        Matcher matcher = pattern.matcher(text);
        String test = "汉";
        byte[] bytes = test.getBytes(Charset.forName("UTF-8"));
        System.out.println(Integer.toHexString(-26));



        System.out.println(Arrays.toString(bytes));

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
