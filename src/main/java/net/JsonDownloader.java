package net;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by jacob on 14/10/26.
 */
public class JsonDownloader {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.ly.com/scenery/AjaxHelper/SceneryPriceFrame.aspx?action=GETJSONSPNEWFORLIST&showCount=2&ids=181999&isSimple=1&isShowAppThree=0&priceList=1&tabself=1&tabHotel=1&tabEatery=1&isGrap=1&nobookid=&iid=0.4260206390172243");

        HttpGet httpGet1 = new HttpGet("http://www.ly.com/scenery/SearchList.aspx?&action=getlist&page=1&kw=&pid=25&cid=0&cyid=0&theme=0&grade=0&money=0&sort=0&paytype=0&ismem=0&istuan=0&isnow=0&spType=&isyiyuan=0&iid=0.28268704866059124");

        HttpGet httpGet2 = new HttpGet("http://www.ly.com/scenery/BookSceneryTicket_32479.html");

        CloseableHttpResponse execute = client.execute(httpGet2);

        HttpEntity entity = execute.getEntity();
        String s = EntityUtils.toString(entity);
        System.out.println(s);

    }
}
