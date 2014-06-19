package inspiration;


import inspiration.tool.TimeTool;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;

/**
 * Created by Administrator on 2014/6/17.
 */
public class PageDownloader implements Runnable {


    static Logger logger = LogManager.getLogger(PageDownloader.class);
    String hudongItemName;
    String url;

    public PageDownloader(String hudongItemName) {
        this.hudongItemName = hudongItemName;
        this.url = ConstResource.hudongPrefix + hudongItemName;
    }

    public static void main(String[] args) {

        new Thread(new PageDownloader("菲利普·马萨")).start();

    }

    @Override
    public void run() {
        download();
    }

    private void download() {

        synchronized (ConstResource.urlMap) {
            ConstResource.urlMap.put(hudongItemName, TimeTool.getCurrentTime());
        }

        try {
            URL url1 = new URL(url);
            InputStream input = url1.openConnection().getInputStream();
            String html = IOUtils.toString(input);
            Document htmlObj = Jsoup.parse(html);
            Elements links = htmlObj.getElementsByTag("a");


            HashMap<String, String> urlMapLocal = new HashMap<String, String>();

            for (Element e : links) {
                String href = e.attr("href");
                Matcher matcher = ConstResource.pattern.matcher(href);
                if (matcher.find()) {
                    String hudongItem = matcher.group(1);
                    hudongItem = URLDecoder.decode(hudongItem, "UTF-8");
                    urlMapLocal.put(hudongItem, "waiting");
                }
            }

            synchronized (ConstResource.urlMap) {
                ConstResource.urlMap.putAll(urlMapLocal);
            }


            saveToFile(hudongItemName, urlMapLocal.keySet(), html);
            System.out.println("finish " + hudongItemName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile(String hudongItemName, Set<String> links, String html) {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add(hudongItemName + "\n");
        lines.add("-------------------------------------------------------------------------\n");

        lines.add(links.toString() + "\n");
        lines.add("-------------------------------------------------------------------------\n");
        lines.add(html + "\n");
        lines.add("-------------------------------------------------------------------------\n");
        try {
            FileUtils.writeLines(ConstResource.savedFile(hudongItemName), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
