package net.quora;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by jacob on 14/12/11.
 */
public class Main {

    static String initUrl = "https://www.quora.com/";

    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(initUrl);

        CloseableHttpResponse response = client.execute(httpGet);
        String content = EntityUtils.toString(response.getEntity());
        System.out.println(content);

    }
}
