package inspiration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2014/6/19.
 */
public class HudongDownloadMain {

    static Logger logger = LogManager.getLogger(HudongDownloadMain.class);

    public static void main(String[] args) {
        new HudongDownloadMain().start();
    }

    public void start() {
        Executor executor = Executors.newCachedThreadPool();
        //start
        executor.execute(new PageDownloader("雪佛莱"));

        ConcurrentHashMap<String, String> urlMap = ConstResource.urlMap;

        while (true) {
            //check
            HashMap<String, String> finishedList = new HashMap<String, String>();
            for (String item : urlMap.keySet()) {
                if (!urlMap.get(item).startsWith("waiting")) {
                    finishedList.put(item, urlMap.get(item));
                }
            }
            if (finishedList.size() == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            //save finished items

            //remove from urlMap
            synchronized (urlMap) {
                for (String item : finishedList.keySet()) {
                    urlMap.remove(item);
                }
            }

            System.out.println(finishedList);

            if (urlMap.size() < ConstResource.maxThread) {
                for (String item : urlMap.keySet()) {
                    executor.execute(new PageDownloader(item));
                }
            } else {
                int i = 0;
                for (String item : urlMap.keySet()) {
                    executor.execute(new PageDownloader(item));
                    i++;
                    if (i == ConstResource.maxThread) {
                        break;
                    }
                }
            }


        }
    }

}
