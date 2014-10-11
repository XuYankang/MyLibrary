package interview;

import java.util.HashMap;

/**
 * Created by jacob on 14-10-10.
 */
public class MyHashTable {

    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable();
        myHashTable.set("a", "1");
        myHashTable.set("b", "2");
        myHashTable.setAll("100");
        System.out.println(myHashTable.get("a"));
        myHashTable.set("a", "3");
        System.out.println(myHashTable.get("a"));
    }

    HashMap<String, String> original;
    HashMap<String, String> afterSetAll;

    String allValue = null;

    public MyHashTable() {
        original = new HashMap<String, String>();
        afterSetAll = new HashMap<String, String>();
    }

    void set(String key, String value) {
        original.put(key, value);
        afterSetAll.put(key, value);
    }

    void setAll(String value) {
        afterSetAll.clear();
        allValue = value;
    }

    String get(String key) {
        String value1 = afterSetAll.get(key);
        if (value1 != null) {
            return value1;
        }
        String value2 = original.get(key);
        if (value2 != null) {
            return allValue;
        }
        return null;
    }
}
