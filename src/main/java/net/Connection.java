package net;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Jacob on 2014/6/11.
 */
public class Connection {
    public static void main(String[] args) {

    }

    public static String monitor(String url, String html) {
        return monitor(0, url, html);
    }

    public static String monitor(String id, String url, String html) {
        return monitor(Integer.parseInt(id), url, html);
    }

    public static String monitor(int id, String urlString, String html) {
        BufferedReader reader = null;
        String request = "http://example.com/index.php";

        try {

            html = URLEncoder.encode(html, "UTF-8");

            String urlParameters = "id=" + id + "&url=" + urlString + "&html=" + html;
            URL url = new URL(request);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
            connection.setUseCaches(false);

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            InputStream input = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(input));
            String line = reader.readLine();

            return line;


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
