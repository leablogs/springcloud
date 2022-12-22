package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapCompare {
    private static Map<String, String> map = new HashMap<>();
    private static Map<String, String> mapCon = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        int size = 1000000;
        setaa(size);
        long start = System.currentTimeMillis();
        mapSet(size);
        System.out.println(System.currentTimeMillis() - start);
        long start1 = System.currentTimeMillis();
        concurrentMapSet(size);
        System.out.println(System.currentTimeMillis() - start1);
    }

    private static void setaa(int size) {

        for (int i = 0; i < size; i++) {
            map.put("a" + i, "value" + i);
        }
        for (int i = 0; i < size; i++) {
            mapCon.put("a" + i, "value" + i);
        }
    }

    private static void mapSet(int size) {

        for (int i = 0; i < size; i++) {
            map.get("a" + i);
        }
    }

    private static void concurrentMapSet(int size) {

        for (int i = 0; i < size; i++) {
            mapCon.get("a" + i);
        }
    }
}
