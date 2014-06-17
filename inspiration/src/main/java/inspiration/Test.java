package inspiration;


import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Administrator on 2014/6/17.
 */
public class Test {

    public static void main(String[] args) {
        String url = "http://www.baike.com/wiki/%E8%BF%88%E5%85%8B%E5%B0%94%C2%B7%E8%88%92%E9%A9%AC%E8%B5%AB&prd=shouye_newslist";

        try {
            URL url1 = new URL(url);
            InputStream input = url1.openConnection().getInputStream();
            String html = IOUtils.toString(input);
            Document htmlObj = Jsoup.parse(html);
            Elements links = htmlObj.getElementsByTag("a");

            ArrayList<String> urlList = new ArrayList<String>();

            for (Element e : links) {
                e.attr("href").matches("");
            }

            System.out.println(links);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
