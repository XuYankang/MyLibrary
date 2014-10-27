package concurrency;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by jacob on 14/10/24.
 */
public class ConcurrentSet {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        Set set = map.keySet();

    }
}
